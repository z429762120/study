package com.tool.collect.skytools.xmlparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/30 下午5:14
 **/
@Data
@NoArgsConstructor
@XStreamAlias("BODY")
public class Body {
    @XStreamAlias("TRANS_SUM")
    private TransSum transSum;
    @XStreamAlias("TRANS_DETAILS")
    private List<TransDetail> transDetails;
}
