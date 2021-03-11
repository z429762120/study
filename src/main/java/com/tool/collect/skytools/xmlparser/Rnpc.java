package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/30 下午3:20
 **/
@NoArgsConstructor
@Data
@XStreamAlias("RNPC")
public class Rnpc {
    @XStreamAlias("MERCHANT_ID")
    private String merchantId;//商户代码;
    @XStreamAlias("SRCREQSN")
    private String srcReqSn;//原请求流水
    @XStreamAlias("VERCODE")
    private String verCode;//短信验证码
}
