package cn.majingjing.majjwscxf.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

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

    @WebMethod(operationName = "xxxx")
    @RequestWrapper(localName = "myRequest")
    @ResponseWrapper(localName = "myResp")
    void inputAndOutPut(
            @WebParam(name = "name")
                    String name,
            @WebParam(name = "id")
                    String id,
            @WebParam(name = "dto", mode = WebParam.Mode.OUT)
                    Holder<Dto> dto,
            @WebParam(name = "bizId",mode = WebParam.Mode.OUT)
                    Holder<Integer> bizId,
            @WebParam(name = "bizName", mode = WebParam.Mode.OUT)
                    Holder<String> bizName);
}
