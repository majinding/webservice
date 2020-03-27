package cn.majingjing.majjwscxf.config;


import cn.majingjing.majjwscxf.ws.HelloPortImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Author JingjingMa
 * @Date 2019/8/2 22:13
 */
@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloPortImpl());
        endpoint.publish("/Hello");
        return endpoint;
    }
}
