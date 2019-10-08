package com.tool.collect.skytools.support.wechatpay;

import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import java.util.*;

/**
 * 微信支付签名
 *
 * @author yangran
 * @create 2017/9/12
 */
public class WechatPaySign {

    protected static final Log log = LoggerFactory.make();

    /**
     * 签名方式：key1=value1&key2=value2....keyn=valuen&key=securityKey  进行MD5
     * <p>要先对Key进行按字典升序排序
     * @param dataMap 数据
     * @param securityKey 密钥
     * @param charset
     * @return
     */
    public static String getSignContentMD5(Map<String,String> dataMap, String securityKey, String charset){
        if(dataMap == null) return null;

        Set<String> keySet = dataMap.keySet();
        List<String> keyList = new ArrayList<String>(keySet);

        Collections.sort(keyList);
        StringBuilder toMD5StringBuilder = new StringBuilder();
        for(String key : keyList){
            String value = dataMap.get(key);

            if(value != null && value.length()>0){
                toMD5StringBuilder.append(key+"="+ value+"&");
            }
        }

        try{
            String stringSignTemp = toMD5StringBuilder.append("key="+securityKey).toString();
            String signValue = MD5.md5(stringSignTemp,charset).toUpperCase();
            return signValue;
        }catch (Exception e){
            return "";
        }
    }

    /**
     * 获取签名 md5加密(微信支付必须用MD5加密)
     * 获取支付签名
     * @param params
     * @return
     */
    public static String getSign(SortedMap<String, String> params,String securityKey,String charset){
        String sign = null;
        StringBuffer sb = new StringBuffer();
        Set es = params.entrySet();
        Iterator iterator = es.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)&& !"key".equals(k)) {
                sb.append(k+"="+v+"&");
            }
        }
        sb.append("key="+securityKey);
        try {
            sign = MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
            return sign;
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean validSign(Map<String,String> dataMap, String securityKey,String currentSignature){
        String sign = getSignContentMD5(dataMap,securityKey,"UTF-8");
        return currentSignature.equals(sign);
    }

}
