package cn.majingjing.majjwscxf.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Author JingjingMa
 * @Date 2019/8/2 22:15
 */
@WebService(name = "Hello")
public interface Hello {
    @WebResult()
    @WebMethod()
    String name(@WebParam(name = "name") String name);

    @WebMethod()
    Dto namedto(Dto dto);
}
