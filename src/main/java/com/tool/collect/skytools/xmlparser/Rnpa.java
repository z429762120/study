package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/30 上午9:57
 **/
@Data
@NoArgsConstructor
@XStreamAlias("RNPA")
public class Rnpa {
    @XStreamAlias("MERCHANT_ID")
    private String merchantId;	//商户代码
    @XStreamAlias("BANK_CODE")
    private String bankCode; //银行代码
    @XStreamAlias("ACCOUNT_TYPE")
    private String accountType;//	账号类型
    @XStreamAlias("ACCOUNT_NO")
    private String accountNo;//	账号
    @XStreamAlias("ACCOUNT_NAME")
    private String accountName;//	账号名
    @XStreamAlias("ACCOUNT_PROP")
    private String accountProp;//	账号属性
    @XStreamAlias("ID_TYPE")
    private String idType;//	开户证件类型
    @XStreamAlias("ID")
    private String id;//	证件号
    @XStreamAlias("TEL")
    private String tel;//	手机号/小灵通
    @XStreamAlias("MERREM")
    private String merrem;//	商户保留信息
    @XStreamAlias("REMARK")
    private String remark;//	备注
}
