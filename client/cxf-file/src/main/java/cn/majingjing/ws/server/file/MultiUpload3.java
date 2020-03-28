
package cn.majingjing.ws.server.file;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>multiUpload3 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="multiUpload3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tmFileBeanList" type="{http://file.server.ws.majingjing.cn/}TmFileBeanList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multiUpload3", propOrder = {
    "tmFileBeanList"
})
public class MultiUpload3 {

    protected TmFileBeanList tmFileBeanList;

    /**
     * 获取tmFileBeanList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TmFileBeanList }
     *     
     */
    public TmFileBeanList getTmFileBeanList() {
        return tmFileBeanList;
    }

    /**
     * 设置tmFileBeanList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TmFileBeanList }
     *     
     */
    public void setTmFileBeanList(TmFileBeanList value) {
        this.tmFileBeanList = value;
    }

}
