package cn.majingjing.ws.server.file;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * CXF上传和下载文件对象包装类 由于CXF的DataHandler无法获取文件名和文件类型，需要在上传和下载时附带文件名
 */
@XmlType(name = "TmFileBeanList")
public class TmFileBeanList {

   private List<TmFileBean> list;

    public List<TmFileBean> getList() {
        return list;
    }

    public void setList(List<TmFileBean> list) {
        this.list = list;
    }
}
