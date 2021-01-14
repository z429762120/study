package com.tool.collect.skytools.support.utility;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @Descriiption XStream 解析
 * @Author bo
 * @Date 2021/1/11 下午12:03
 **/
public class XmlUtility1 {


    public static <T> T toBean(String xml, Class<T> clazz) {
        XStream xstream = initXStream();
        xstream.processAnnotations(clazz);
        final Object o = xstream.fromXML(xml);
        return (T) o;
    }


    public static  <T> String toXml(T t) {
        XStream xstream = initXStream();
        xstream.processAnnotations(t.getClass());
        return xstream.toXML(t).replaceAll("__", "_");
    }
    private static XStream initXStream() {
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypesByWildcard(new String[] { "com.ywkj.pay.center.**"});
        return xstream;
    }
}
