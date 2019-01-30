package cn.majingjing.ws.server.file;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CxfServerPublish {
    public static void main(String args[]) throws Exception {
        FilePortImpl filePortImpl = new FilePortImpl();
        ArrayList<Interceptor> inInterceptors = new ArrayList();
//        inInterceptors.add(new MyAbstractPhaseInterceptor());
        inInterceptors.add(new LoggingInInterceptor(102400 * 100));
        ArrayList<Interceptor> outInterceptors = new ArrayList();
        outInterceptors.add(new LoggingOutInterceptor());

        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        Map<String, Object> props = new HashMap<>();
        props.put("mtom-enabled", Boolean.TRUE);
        factory.setProperties(props);
        //ServerFactoryBean factory = new ServerFactoryBean();
        factory.setServiceClass(FilePortImpl.class);
        factory.setAddress("http://127.0.0.1:8080/ws/file");
        factory.setServiceBean(filePortImpl);
        factory.setInInterceptors(inInterceptors);
        factory.setOutInterceptors(outInterceptors);
        factory.create();


    }
}
