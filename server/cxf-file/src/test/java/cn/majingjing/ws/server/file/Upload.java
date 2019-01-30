
package cn.majingjing.ws.server.file;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>upload complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="upload">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tmFileBean" type="{http://file.server.ws.majingjing.cn/}TmFileBean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upload", propOrder = {
    "tmFileBean"
})
public class Upload {

    protected TmFileBean tmFileBean;

    /**
     * 获取tmFileBean属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TmFileBean }
     *     
     */
    public TmFileBean getTmFileBean() {
        return tmFileBean;
    }

    /**
     * 设置tmFileBean属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TmFileBean }
     *     
     */
    public void setTmFileBean(TmFileBean value) {
        this.tmFileBean = value;
    }

}
