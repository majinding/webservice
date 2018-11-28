package cn.majingjing.ws.server;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by JingjingMa on 2018/11/26 17:55
 * <p>
 * 使用dom4j来完成xml的解析操作
 */
public class WsXmlUtils {

    /**
     * xml转成map
     *
     * @param xmlStr
     * @return
     * @throws DocumentException
     */
    public static Map xmlToMap(String xmlStr) throws DocumentException {
        Document doc = DocumentHelper.parseText(xmlStr);
        Element root = doc.getRootElement();
        Map<String, Object> map = (Map<String, Object>) xmlToMap(root);
        if (root.elements().size() == 0 && root.attributes().size() == 0) {
            return map;
        }
        //在返回的map里加根节点键（如果需要）
        Map<String, Object> rootMap = new HashMap<>();
        rootMap.put(root.getName(), map);
        return rootMap;
    }


    private static Object xmlToMap(Element element) {
        Map<String, Object> map = new LinkedHashMap<>();
        List<Element> elements = element.elements();
        if (elements.size() == 0) {
            map.put(element.getName(), element.getText());
            if (!element.isRootElement()) {
                return element.getText();
            }
        } else if (elements.size() == 1) {
            map.put(elements.get(0).getName(), xmlToMap(elements.get(0)));
        } else if (elements.size() > 1) {
            // 多个子节点的话就得考虑list的情况了，比如多个子节点有节点名称相同的
            // 构造一个map用来去重
            Map<String, Element> tempMap = new LinkedHashMap<String, Element>();
            for (Element ele : elements) {
                tempMap.put(ele.getName(), ele);
            }
            Set<String> keySet = tempMap.keySet();
            for (String string : keySet) {
                Namespace namespace = tempMap.get(string).getNamespace();
                List<Element> elements2 = element.elements(new QName(string, namespace));
                // 如果同名的数目大于1则表示要构建list
                if (elements2.size() > 1) {
                    List<Object> list = new ArrayList<>();
                    for (Element ele : elements2) {
                        if (null == (ele.getText()) || "".equals(ele.getText())) continue;
                        list.add(xmlToMap(ele));
                    }
                    map.put(string, list);
                } else {
                    // 同名的数量不大于1则直接递归去
                    map.put(string, xmlToMap(elements2.get(0)));
                }
            }
        }

        return map;
    }
}
