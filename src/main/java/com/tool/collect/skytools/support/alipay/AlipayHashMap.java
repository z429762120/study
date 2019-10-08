package com.tool.collect.skytools.support.alipay;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tool.collect.skytools.support.utility.JsonUtility;
import com.tool.collect.skytools.support.utility.StringUtility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Gnoll
 * @create 2017-08-02 21:02
 **/
public class AlipayHashMap extends HashMap<String, String> {

    public AlipayHashMap() {
        super();
    }

    public AlipayHashMap(Map<? extends String, ? extends String> m) {
        super(m);
    }

    public String put(String key, Object value) {
        String strValue;

        if (value == null) {
            strValue = null;
        } else if (value instanceof String) {
            strValue = (String) value;
        } else if (value instanceof Integer) {
            strValue = ((Integer) value).toString();
        } else if (value instanceof Long) {
            strValue = ((Long) value).toString();
        } else if (value instanceof Float) {
            strValue = ((Float) value).toString();
        } else if (value instanceof Double) {
            strValue = ((Double) value).toString();
        } else if (value instanceof Boolean) {
            strValue = ((Boolean) value).toString();
        } else if (value instanceof Date) {
            DateFormat format = new SimpleDateFormat(AlipayConstants.DATE_TIME_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(AlipayConstants.DATE_TIMEZONE));
            strValue = format.format((Date) value);
        } else if (value instanceof ObjectNode) {
            try {
                strValue = JsonUtility.toString(value);
            } catch (Exception e) {
                strValue = "";
            }
        } else {
            strValue = value.toString();
        }

        return this.put(key, strValue);
    }

    public String put(String key, String value) {
        if (StringUtility.allNotBlank(key, value)) {
            return super.put(key, value);
        } else {
            return null;
        }
    }
}
