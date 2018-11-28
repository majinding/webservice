package cn.majingjing.ws.server;

import org.dom4j.DocumentException;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by JingjingMa on 2018/11/28 17:02
 *
 * 安全验证
 */
public class SecuritySoapHandler implements SOAPHandler<SOAPMessageContext> {


    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("run handleFault method!");
        return false;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("run handleMessage method!");
        Boolean out = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        try {
            SOAPMessage message = context.getMessage();
            message.writeTo(baout);
            String xml = baout.toString();
            if (out) {
                System.out.println("响应报文：\n" + xml);
            } else {
                System.out.println("请求报文：\n" + xml);

                //验证
                if(!auth(xml)){

                    //验证失败,构建失败信息返回给客户端
                    buildFailSoapMessage(message);
                    return false;
                }
            }

        } catch (Exception e1) {
            //System.err.println("解析报文出错：\n" + e1.getMessage());
            e1.printStackTrace();
        } finally {
            if (baout != null) {
                try {
                    baout.close();
                } catch (IOException e) {
                }
            }
        }

        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("run close method!---------");
        System.out.println(context);
        System.out.println("run close method!");
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }


    /**
     * 授权校验
     * @param xml
     * @return
     */
    private boolean auth(String xml){
        try {
            //此处为了取出header,将xml转换成map(简化从header中取用户名和密码,效率问题此处不考虑,只是演示示例,不考虑性能问题,勿喷!)
            Map map = WsXmlUtils.xmlToMap(xml);
            System.out.println(map);//{Envelope={Header={AuthenticationToken={Username=zhansan, Password=123456}}, Body={abc={arg0=bc}}}}

            Map authenticationToken = (Map)((Map) (((Map) map.get("Envelope")).get("Header"))).get("AuthenticationToken");
            if("zhansan".equals(authenticationToken.get("Username")) && "123456".equals(authenticationToken.get("Password"))){
                return true;
            }
        } catch (DocumentException e) {
            return false;
        }

        return false;
    }

    /**
     * 构建SOAPFault
     * @param message
     */
    private void buildFailSoapMessage(SOAPMessage message) {
        try {
            SOAPEnvelope envelop = message.getSOAPPart().getEnvelope();

            //删除原始header,再重新构建
            envelop.getHeader().detachNode();
            envelop.addHeader();

            //删除原始body,再重新构建
            envelop.getBody().detachNode();
            SOAPBody body = envelop.addBody();

            //构建失败信息
            SOAPFault fault = body.getFault();

            if (fault == null) {
                fault = body.addFault();
            }

            fault.setFaultString("授权失败！");

            message.saveChanges();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

}
