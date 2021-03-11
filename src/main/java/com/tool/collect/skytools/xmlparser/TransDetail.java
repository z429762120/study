package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/30 下午3:33
 **/
@NoArgsConstructor
@Data
@XStreamAlias("TRANS_DETAIL")
public class TransDetail {
    /**
     * 记录序号 长度1-4，一个请求之内唯一
     */
    @XStreamAlias("SN")
    private String sn = "";
    /**
     * 用户编号 长度1-20
     */
    @XStreamAlias("E_USER_CODE")
    private String eUserCode = "";
    /**
     * 银行代码 长度4-8
     */
    @XStreamAlias("BANK_CODE")
    private String bankCode = "";
    /**
     * 账号类型 长度2
     * 00银行卡，01存折，02信用卡。不填默认为银行卡00。存折不填写将失败
     */
    @XStreamAlias("ACCOUNT_TYPE")
    private String accountType = "";
    /**
     * 银行卡或者存折 长度1-32
     */
    @XStreamAlias("ACCOUNT_NO")
    private String accountNo = "";
    /**
     * 银行卡或存折上的所有人姓名。 长度1-60
     */
    @XStreamAlias("ACCOUNT_NAME")
    private String accountName = "";
    /**
     * 开户行所在省 不带“省”或“自治区”
     */
    @XStreamAlias("PROVINCE")
    private String province = "";
    /**
     * 开户行所在市 不带“市”，如 广州，南宁等。 如果是直辖市，则填区，如北京（市）朝阳（区）
     */
    @XStreamAlias("CITY")
    private String city = "";
    /**
     * 开户行名称 开户行详细名称，也叫网点，如 中国建设银行广州东山广场分理处
     */
    @XStreamAlias("BANK_NAME")
    private String bankName = "";
    /**
     * 账号属性 0私人，1公司。不填时，默认为私人0。
     */
    @XStreamAlias("ACCOUNT_PROP")
    private String accountProp = "";
    /**
     * 金额 单位分
     */
    @XStreamAlias("AMOUNT")
    private String amount = "";
    /**
     * 货币类型 人民币：CNY, 港元：HKD，美元：USD。不填时，默认为人民币。
     */
    @XStreamAlias("CURRENCY")
    private String currency = "";
    /**
     * 协议号
     */
    @XStreamAlias("PROTOCOL")
    private String protocol = "";
    /**
     * 协议用户编号
     */
    @XStreamAlias("PROTOCOL_USER")
    private String protocolUser = "";
    /**
     * 开户证件类型
     */
    @XStreamAlias("ID_TYPE")
    private String idType = "";
    /**
     * 证件号
     */
    @XStreamAlias("ID")
    private String id = "";
    /**
     * 手机号
     */
    @XStreamAlias("TEL")
    private String tel = "";
    /**
     * 自定义用户号 长度128
     */
    @XStreamAlias("CUST_USERID")
    private String custUserId = "";
    /**
     * 备注 长度50
     */
    @XStreamAlias("REMARK")
    private String remark = "";
    /**
     * 本交易结算户 长度32
     * 结算到商户的账户，不需分别清算时不需填写。
     */
    @XStreamAlias("SETTACCT")
    private String settAcct = "";
    /**
     * 分组清算标志 长度1-30
     */
    @XStreamAlias("SETTGROUPFLAG")
    private String settGroupFlag = "";
    /**
     * 交易附言 长度1-140
     * 填入网银的交易备注,可以在网银明细中查询到该字段信息，但部分银行可能不支持
     */
    @XStreamAlias("SUMMARY")
    private String summary = "";
    /**
     * 支付行号 长度1-12
     */
    @XStreamAlias("UNION_BANK")
    private String unionBank = "";
    /**
     * 交易结果通知地址 长度200
     */
    @XStreamAlias("NOTIFYURL")
    private String notifyUrl;

    public static TransDetail newInstance() {
        TransDetail transDetail = new TransDetail();
        transDetail.setSn("0000000000000020000011111");
        transDetail.setEUserCode(StringUtils.EMPTY);
        transDetail.setBankCode("0104");
        transDetail.setAccountType(StringUtils.EMPTY);
        transDetail.setAccountNo("9558801404101433484");
        transDetail.setAccountName("刘波");
        transDetail.setProvince(StringUtils.EMPTY);
        transDetail.setCity(StringUtils.EMPTY);
        transDetail.setBankName(StringUtils.EMPTY);
        transDetail.setAccountProp(StringUtils.EMPTY);
        transDetail.setAmount("2000");
        transDetail.setCurrency("CNY");
        transDetail.setProtocol(StringUtils.EMPTY);
        transDetail.setProtocolUser(StringUtils.EMPTY);
        transDetail.setIdType(StringUtils.EMPTY);
        transDetail.setId(StringUtils.EMPTY);
        transDetail.setTel(StringUtils.EMPTY);
        transDetail.setCustUserId(StringUtils.EMPTY);
        transDetail.setRemark(StringUtils.EMPTY);
        transDetail.setSettAcct(StringUtils.EMPTY);
        transDetail.setSettGroupFlag(StringUtils.EMPTY);
        transDetail.setSummary(StringUtils.EMPTY);
        transDetail.setUnionBank(StringUtils.EMPTY);
        transDetail.setNotifyUrl(StringUtils.EMPTY);
        return transDetail;
    }
}
