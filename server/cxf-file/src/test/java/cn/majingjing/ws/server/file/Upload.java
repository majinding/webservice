
package cn.majingjing.ws.server.file;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>upload complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡtmFileBean���Ե�ֵ��
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
     * ����tmFileBean���Ե�ֵ��
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
