package cn.majingjing.ws.server;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author JingjingMa
 * @date 2017-11-29
 */
@WebService
@HandlerChain(file = "service-handler-chain.xml")
public class HelloApi {

    @WebMethod
    public String abc(String def) {
        return "hello: " + def;
    }


}
