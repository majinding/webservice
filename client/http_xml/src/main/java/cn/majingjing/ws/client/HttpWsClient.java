package cn.majingjing.ws.client;

import org.junit.Test;

import java.util.Map;

/**
 * Created by JingjingMa on 2018/11/27 11:09
 */
public class HttpWsClient {

    @Test
    public void helloObject() throws Exception {
        //请求地址
        String url = "https://www.majingjing.cn/tmblog/webservice/hellodemo";

        //动态参数
        String id = "123";
        String name = "abc";

        //构造请求xml
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.webservice.blog.tm.majingjing.cn/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <api:helloObject>\n" +
                "         <arg0>\n" +
                "            <id>"+id+"</id>\n" +
                "            <name>"+name+"</name>\n" +
                "         </arg0>\n" +
                "      </api:helloObject>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        //请求ws
        String respXml = WsHttpRequest.doPost(url, xml);
        System.out.println(respXml);

        //解析响应xml(考虑到解析成对象会因为ws的返回值不同会有差异,所以这里解析成map方便通用处理)
        Map map = WsXmlUtils.xmlToMap(respXml);
        System.out.println(map);

    }

}
