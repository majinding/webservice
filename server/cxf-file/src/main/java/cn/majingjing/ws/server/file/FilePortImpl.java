package cn.majingjing.ws.server.file;

import cn.majingjing.core.tool.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

/**
 * 基于文件上传和下载
 *
 * @author majinding888@foxmail.com
 * @date 2016-12-30 下午5:29:29
 */
@WebService()
@MTOM
public class FilePortImpl {

    private static Logger log = LoggerFactory.getLogger(FilePortImpl.class);

    /**
     * 文件上传
     *
     * @param tmFileBean 文件上传包装类
     * @return 上传成功返回true，上传失败返回false。
     */
    public String upload(@WebParam(name = "tmFileBean") TmFileBean tmFileBean) {

        InputStream is = null;
        try {
            log.info("upload... {}",tmFileBean.getFileName());
            tmFileBean.getFile().writeTo(new FileOutputStream("F:\\tmp\\"+ UUID.randomUUID().toString()+tmFileBean.getFileName()));
            String rtn = Tools.toStrings("文件上传成功，文件名：{}", tmFileBean.getFileName());
            log.debug(rtn);
            return rtn;
        } catch (Exception e) {
            log.error("上传文件失败", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }

        return "文件上传失败，请联系管理员。";
    }

    /**
     * 文件下载
     *
     * @return 文件
     */
    public TmFileBean download() {
//        try {
//            URL url = new URL("https://www.majingjing.cn/tmblog/resources/common/images/favicon.ico");
//            TmFileBean fileWrapper = new TmFileBean();
//            fileWrapper.setFileName("favicon.ico");
//            fileWrapper.setFileExtension("ico");
//
//            DataSource source = new URLDataSource(url);
//            fileWrapper.setFile(new DataHandler(source));
//            return fileWrapper;
//
//        } catch (IOException e) {
//            log.error("下载文件失败", e);
//        }

        try {
            File file = new File("f:\\tmp\\fcbc171b-55bd-45bb-88da-47346cc48105ideaIU-2018.3.3.win.zip");
            TmFileBean fileWrapper = new TmFileBean();
            fileWrapper.setFileName("ideaIU-2018.3.3.win.zip");
            fileWrapper.setFileExtension("zip");

            DataSource source = new FileDataSource(file);
            fileWrapper.setFile(new DataHandler(source));
            return fileWrapper;

        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
        return null;
    }

}
