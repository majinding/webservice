package cn.majingjing.majjwscxf.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * @Author JingjingMa
 * @Date 2019/8/2 22:14
 */
@WebService
public class HelloPortImpl implements Hello {

    @Override
    public String name(String name) {
        return "Hello, Welcome to CXF Spring boot 2.1.3.RELEASE " + name + "!!!";
    }

    @Override
    public Dto namedto(Dto dto) {
        Dto d = new Dto();
        d.setId("server :" + dto.getId());
        d.setName("server :" + dto.getName());
        return d;
    }

    @Override
    public void inputAndOutPut(String name, String id, Holder<Dto> dto, Holder<Integer> bizId, Holder<String> bizName) {
        Dto d = new Dto();
        d.setId("server :1");
        d.setName("server : majingjing");
        dto.value = d;
        bizId.value = 1;
        bizName.value = "biz-" + name;
    }



}
