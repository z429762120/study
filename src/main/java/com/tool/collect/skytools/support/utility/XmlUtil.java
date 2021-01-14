package com.tool.collect.skytools.support.utility;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @Descriiption XStream 解析
 * @Author bo
 * @Date 2021/1/11 下午12:03
 **/
public class XmlUtil {

    public static <T> T toBean(String xml, Class<T> clazz) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(clazz);
        final Object o = xstream.fromXML(xml);
        return (T) o;
    }


    public static  <T> String toXml(T t, Class<T> clazz) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(clazz);
        return xstream.toXML(t).replaceAll("__", "_");
    }
}
