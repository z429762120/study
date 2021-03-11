package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Descriiption 银行卡四要素+短信验证 步骤一
 * @Author bo
 * @Date 2020/12/30 下午2:42
 **/
@Data
@NoArgsConstructor
@XStreamAlias("AIPG")
public class AipgSms1 {
    @XStreamAlias("INFO")
    private InfoReq info;
    @XStreamAlias("RNPA")
    private Rnpa rnpa;
}
