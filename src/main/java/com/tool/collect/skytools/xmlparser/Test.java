package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/30 下午2:45
 **/
public class Test {
    public static void main(String[] args) {
        final String xml = batchDaiFu();
        final AipgDaiFu daiFu = toBean(xml, AipgDaiFu.class);
        System.out.println(daiFu);



    }

    private static <T> T toBean(String xml, Class<T> clazz) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(clazz);
        final Object o = xstream.fromXML(xml);
        return (T) o;
    }

    private static String batchDaiFu() {
        InfoReq infoReq = InfoReq.newInstance();
        TransSum transSum = TransSum.newInstance();

        TransDetail transDetail1 = TransDetail.newInstance();
        TransDetail transDetail2 = TransDetail.newInstance();
        List<TransDetail> transDetails = new ArrayList<>();
        transDetails.add(transDetail1);
        transDetails.add(transDetail2);
        Body body = new Body();
        body.setTransSum(transSum);
        body.setTransDetails(transDetails);

        AipgDaiFu daiFu = new AipgDaiFu();
        daiFu.setInfo(infoReq);
        daiFu.setBody(body);
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(AipgDaiFu.class);
        final String toXML = xstream.toXML(daiFu).replaceAll("__", "_");
        System.out.println(toXML);
        return toXML;
    }

    /**
     * 银行卡四要素+短信验证步骤1
     * @return
     */
    private static String bankCardverify() {
        InfoReq infoReq = new InfoReq();
        infoReq.setTrxCode("21007");
        infoReq.setVersion("04");
        infoReq.setDataType(StringUtils.EMPTY);
        infoReq.setLevel(StringUtils.EMPTY);
        infoReq.setMerchantId(StringUtils.EMPTY);
        infoReq.setUserName(StringUtils.EMPTY);
        infoReq.setUserPass(StringUtils.EMPTY);
        infoReq.setReqSn(StringUtils.EMPTY);
        infoReq.setSignedMsg(StringUtils.EMPTY);

        Rnpa rnpa = new Rnpa();
        rnpa.setMerchantId(StringUtils.EMPTY);
        rnpa.setBankCode(StringUtils.EMPTY);
        rnpa.setAccountType(StringUtils.EMPTY);
        rnpa.setAccountNo(StringUtils.EMPTY);
        rnpa.setAccountName(StringUtils.EMPTY);
        rnpa.setAccountProp(StringUtils.EMPTY);
        rnpa.setIdType(StringUtils.EMPTY);
        rnpa.setId(StringUtils.EMPTY);
        rnpa.setTel(StringUtils.EMPTY);
        rnpa.setMerrem(StringUtils.EMPTY);
        rnpa.setRemark(StringUtils.EMPTY);

        AipgSms1 aipgSms1 = new AipgSms1();
        aipgSms1.setInfo(infoReq);
        aipgSms1.setRnpa(rnpa);

        //XStream xstream = new XStream(new DomDriver("GBK"));
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(AipgSms1.class);
        final String toXML = xstream.toXML(aipgSms1).replaceAll("__", "_");
        if (toXML.indexOf("<SIGNED_MSG></SIGNED_MSG>")>-1) {
            System.out.println(toXML.replaceAll("<SIGNED_MSG></SIGNED_MSG>", ""));
        }
        return toXML;
    }
}
