
package cn.majingjing.ws.server.file;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FilePortImpl", targetNamespace = "http://file.server.ws.majingjing.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FilePortImpl {


    /**
     * 
     * @return
     *     returns cn.majingjing.ws.server.file.TmFileBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "download", targetNamespace = "http://file.server.ws.majingjing.cn/", className = "cn.majingjing.ws.server.file.Download")
    @ResponseWrapper(localName = "downloadResponse", targetNamespace = "http://file.server.ws.majingjing.cn/", className = "cn.majingjing.ws.server.file.DownloadResponse")
    public TmFileBean download();

    /**
     * 
     * @param tmFileBeans
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "multiUpload", targetNamespace = "http://file.server.ws.majingjing.cn/", className = "cn.majingjing.ws.server.file.MultiUpload")
    @ResponseWrapper(localName = "multiUploadResponse", targetNamespace = "http://file.server.ws.majingjing.cn/", className = "cn.majingjing.ws.server.file.MultiUploadResponse")
    public String multiUpload(
        @WebParam(name = "tmFileBeans", targetNamespace = "")
        List<TmFileBean> tmFileBeans);

    /**
     * 
     * @param tmFileBean
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "upload", targetNamespace = "http://file.server.ws.majingjing.cn/", className = "cn.majingjing.ws.server.file.Upload")
    @ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://file.server.ws.majingjing.cn/", className = "cn.majingjing.ws.server.file.UploadResponse")
    public String upload(
        @WebParam(name = "tmFileBean", targetNamespace = "")
        TmFileBean tmFileBean);

}