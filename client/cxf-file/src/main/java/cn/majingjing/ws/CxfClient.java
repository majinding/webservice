package cn.majingjing.ws;

import cn.majingjing.ws.server.file.FilePortImpl;
import cn.majingjing.ws.server.file.TmFileBean;
import cn.majingjing.ws.server.file.TmFileBeanList;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CxfClient {
    private static Logger log = LoggerFactory.getLogger(CxfClient.class);

    FilePortImpl fileWS = null;

    @Before
    public void before() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("mtom-enabled", Boolean.TRUE); // Boolean.TRUE or "true" will work as the property value here
        factory.setProperties(props);

        factory.setServiceClass(FilePortImpl.class);
        factory.setAddress("http://127.0.0.1:8080/ws/file");
        factory.getInInterceptors().add(new org.apache.cxf.interceptor.LoggingInInterceptor());

        fileWS = (FilePortImpl) factory.create();
    }


    @Test
    public void multiUpload3() {
        List<TmFileBean> tmFileBeans = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            TmFileBean fileWrapper = new TmFileBean();
            fileWrapper.setFileName(i + ".cn.majingjing.txt");
            fileWrapper.setFileExtension("cn/majingjing/txt");

            String filePath = "/Users/apple/Documents/works/git/oschina/webservice/client/cxf-file/src/main/java/cn/majingjing/txt/" + i + ".txt";
            DataSource source = new FileDataSource(new File(filePath));
            fileWrapper.setFile(new DataHandler(source));

            tmFileBeans.add(fileWrapper);
        }
        TmFileBeanList list = new TmFileBeanList();
        list.setList(tmFileBeans);
        String s = fileWS.multiUpload3(list);
        System.out.println(s);

    }

    @Test
    public void multiUpload() {
        List<TmFileBean> tmFileBeans = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            TmFileBean fileWrapper = new TmFileBean();
            fileWrapper.setFileName(i + ".cn.majingjing.txt");
            fileWrapper.setFileExtension("cn/majingjing/txt");

            String filePath = "/Users/apple/Documents/works/git/oschina/webservice/client/cxf-file/src/main/java/cn/majingjing/txt/" + i + ".txt";
            DataSource source = new FileDataSource(new File(filePath));
            fileWrapper.setFile(new DataHandler(source));

            tmFileBeans.add(fileWrapper);
        }

        String s = fileWS.multiUpload(tmFileBeans);
        System.out.println(s);

    }

    @Test
    public void upload() {
        TmFileBean fileWrapper = new TmFileBean();
        fileWrapper.setFileName("ideaIU-2018.3.3.win.zip");
        fileWrapper.setFileExtension("zip");

        String filePath = "C:\\Users\\Administrator\\Downloads\\ideaIU-2018.3.3.win.zip";
        DataSource source = new FileDataSource(new File(filePath));
        fileWrapper.setFile(new DataHandler(source));
        String upload = fileWS.upload(fileWrapper);
        log.info(upload);


    }

    @Test
    public void down() throws IOException {
        TmFileBean download = fileWS.download();
        String s = download.getFileName();
        download.getFile().writeTo(new FileOutputStream("F:\\tmp\\client-" + UUID.randomUUID().toString() + download.getFileName()));
        log.info(s);
    }


}
