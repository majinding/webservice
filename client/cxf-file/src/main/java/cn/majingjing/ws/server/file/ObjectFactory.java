
package cn.majingjing.ws.server.file;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.majingjing.ws.server.file package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MultiUpload2_QNAME = new QName("http://file.server.ws.majingjing.cn/", "multiUpload2");
    private final static QName _MultiUpload3Response_QNAME = new QName("http://file.server.ws.majingjing.cn/", "multiUpload3Response");
    private final static QName _MultiUploadResponse_QNAME = new QName("http://file.server.ws.majingjing.cn/", "multiUploadResponse");
    private final static QName _MultiUpload3_QNAME = new QName("http://file.server.ws.majingjing.cn/", "multiUpload3");
    private final static QName _Download_QNAME = new QName("http://file.server.ws.majingjing.cn/", "download");
    private final static QName _MultiUpload_QNAME = new QName("http://file.server.ws.majingjing.cn/", "multiUpload");
    private final static QName _Upload_QNAME = new QName("http://file.server.ws.majingjing.cn/", "upload");
    private final static QName _DownloadResponse_QNAME = new QName("http://file.server.ws.majingjing.cn/", "downloadResponse");
    private final static QName _UploadResponse_QNAME = new QName("http://file.server.ws.majingjing.cn/", "uploadResponse");
    private final static QName _MultiUpload2Response_QNAME = new QName("http://file.server.ws.majingjing.cn/", "multiUpload2Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.majingjing.ws.server.file
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MultiUpload2 }
     * 
     */
    public MultiUpload2 createMultiUpload2() {
        return new MultiUpload2();
    }

    /**
     * Create an instance of {@link MultiUpload3Response }
     * 
     */
    public MultiUpload3Response createMultiUpload3Response() {
        return new MultiUpload3Response();
    }

    /**
     * Create an instance of {@link MultiUploadResponse }
     * 
     */
    public MultiUploadResponse createMultiUploadResponse() {
        return new MultiUploadResponse();
    }

    /**
     * Create an instance of {@link MultiUpload3 }
     * 
     */
    public MultiUpload3 createMultiUpload3() {
        return new MultiUpload3();
    }

    /**
     * Create an instance of {@link Download }
     * 
     */
    public Download createDownload() {
        return new Download();
    }

    /**
     * Create an instance of {@link MultiUpload }
     * 
     */
    public MultiUpload createMultiUpload() {
        return new MultiUpload();
    }

    /**
     * Create an instance of {@link Upload }
     * 
     */
    public Upload createUpload() {
        return new Upload();
    }

    /**
     * Create an instance of {@link DownloadResponse }
     * 
     */
    public DownloadResponse createDownloadResponse() {
        return new DownloadResponse();
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link MultiUpload2Response }
     * 
     */
    public MultiUpload2Response createMultiUpload2Response() {
        return new MultiUpload2Response();
    }

    /**
     * Create an instance of {@link TmFileBean }
     * 
     */
    public TmFileBean createTmFileBean() {
        return new TmFileBean();
    }

    /**
     * Create an instance of {@link TmFileBeanList }
     * 
     */
    public TmFileBeanList createTmFileBeanList() {
        return new TmFileBeanList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiUpload2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "multiUpload2")
    public JAXBElement<MultiUpload2> createMultiUpload2(MultiUpload2 value) {
        return new JAXBElement<MultiUpload2>(_MultiUpload2_QNAME, MultiUpload2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiUpload3Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "multiUpload3Response")
    public JAXBElement<MultiUpload3Response> createMultiUpload3Response(MultiUpload3Response value) {
        return new JAXBElement<MultiUpload3Response>(_MultiUpload3Response_QNAME, MultiUpload3Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiUploadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "multiUploadResponse")
    public JAXBElement<MultiUploadResponse> createMultiUploadResponse(MultiUploadResponse value) {
        return new JAXBElement<MultiUploadResponse>(_MultiUploadResponse_QNAME, MultiUploadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiUpload3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "multiUpload3")
    public JAXBElement<MultiUpload3> createMultiUpload3(MultiUpload3 value) {
        return new JAXBElement<MultiUpload3>(_MultiUpload3_QNAME, MultiUpload3 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Download }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "download")
    public JAXBElement<Download> createDownload(Download value) {
        return new JAXBElement<Download>(_Download_QNAME, Download.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiUpload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "multiUpload")
    public JAXBElement<MultiUpload> createMultiUpload(MultiUpload value) {
        return new JAXBElement<MultiUpload>(_MultiUpload_QNAME, MultiUpload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "upload")
    public JAXBElement<Upload> createUpload(Upload value) {
        return new JAXBElement<Upload>(_Upload_QNAME, Upload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "downloadResponse")
    public JAXBElement<DownloadResponse> createDownloadResponse(DownloadResponse value) {
        return new JAXBElement<DownloadResponse>(_DownloadResponse_QNAME, DownloadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "uploadResponse")
    public JAXBElement<UploadResponse> createUploadResponse(UploadResponse value) {
        return new JAXBElement<UploadResponse>(_UploadResponse_QNAME, UploadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiUpload2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.server.ws.majingjing.cn/", name = "multiUpload2Response")
    public JAXBElement<MultiUpload2Response> createMultiUpload2Response(MultiUpload2Response value) {
        return new JAXBElement<MultiUpload2Response>(_MultiUpload2Response_QNAME, MultiUpload2Response.class, null, value);
    }

}
