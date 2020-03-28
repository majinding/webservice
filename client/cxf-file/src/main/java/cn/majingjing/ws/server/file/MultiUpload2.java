
package cn.majingjing.ws.server.file;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>multiUpload2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="multiUpload2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tmFileBeans" type="{http://file.server.ws.majingjing.cn/}TmFileBean" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multiUpload2", propOrder = {
    "tmFileBeans"
})
public class MultiUpload2 {

    protected List<TmFileBean> tmFileBeans;

    /**
     * Gets the value of the tmFileBeans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tmFileBeans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTmFileBeans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TmFileBean }
     * 
     * 
     */
    public List<TmFileBean> getTmFileBeans() {
        if (tmFileBeans == null) {
            tmFileBeans = new ArrayList<TmFileBean>();
        }
        return this.tmFileBeans;
    }

}
