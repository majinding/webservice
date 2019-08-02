package cn.majingjing.majjwscxf.ws;

import javax.jws.WebService;

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
        d.setId("server :"+dto.getId());
        d.setName("server :"+dto.getName());
        return d;
    }
}
