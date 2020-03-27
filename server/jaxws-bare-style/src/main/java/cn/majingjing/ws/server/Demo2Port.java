
package cn.majingjing.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * @author JingjingMa
 * @date 2019-11-28
 */
@WebService(name = "demo2Port", targetNamespace = "http://majingjing.cn/demo2/definitions")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class Demo2Port {


    /**
     * 
     * @param demo2Request
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Demo2")
    @WebResult(name = "Demo2Response", targetNamespace = "http://majingjing.cn/demo2/schemas", partName = "Demo2Response")
    public String demo2(
            @WebParam(name = "Demo2Request", targetNamespace = "http://majingjing.cn/demo2/schemas", partName = "Demo2Request")
                    String demo2Request){
        return "hello: "+demo2Request;
    }

}
