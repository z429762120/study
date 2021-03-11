package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/30 下午4:55
 **/
@NoArgsConstructor
@Data
@XStreamAlias("TRANS_SUM")
public class TransSum {
    /**
     * 业务代码
     */
    @XStreamAlias("BUSINESS_CODE")
    private String businessCode = "";
    /**
     * 商户代码
     */
    @XStreamAlias("MERCHANT_ID")
    private String merchantId = "";
    /**
     * 提交时间  YYYYMMDDHHMMSS
     */
    @XStreamAlias("SUBMIT_TIME")
    private String submitTime = "";
    /**
     * 总记录数 最大2000
     */
    @XStreamAlias("TOTAL_ITEM")
    private String totalItem = "";
    /**
     * 总金额 单位分
     */
    @XStreamAlias("TOTAL_SUM")
    private String totalSum = "";
    /**
     * 清算日期 不推荐使用
     */
    @XStreamAlias("SETTDAY")
    private String settDay = "";

    public static TransSum newInstance() {
        TransSum transSum = new TransSum();
        transSum.setBusinessCode("111");
        transSum.setMerchantId("12ssa");
        transSum.setSubmitTime("20201203145833");
        transSum.setTotalItem("1");
        transSum.setTotalSum("12200");
        transSum.setSettDay(StringUtils.EMPTY);
        return transSum;
    }
}
