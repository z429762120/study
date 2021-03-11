package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/30 上午9:35
 **/
@NoArgsConstructor
@Data
@XStreamAlias("INFO")
public class InfoReq {
    @XStreamAlias("TRX_CODE")
    private String trxCode="";
    @XStreamAlias("VERSION")
    private String version="";
    @XStreamAlias("DATA_TYPE")
    private String dataType = "";
    @XStreamAlias("LEVEL")
    private String level="";
    @XStreamAlias("MERCHANT_ID")
    private String merchantId;
    @XStreamAlias("USER_NAME")
    private String userName="";
    @XStreamAlias("USER_PASS")
    private String userPass="";
    @XStreamAlias("REQ_SN")
    private String reqSn="";
    @XStreamAlias("SIGNED_MSG")
    private String signedMsg="";

    public static InfoReq newInstance() {
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
        return infoReq;
    }
}
