package com.tool.collect.skytools.support.alipay;

import lombok.Data;

/**
 * @author Gnoll
 * @create 2017-08-02 21:05
 **/
@Data
public class RequestParametersHolder {
    private AlipayHashMap protocalMustParams;
    private AlipayHashMap protocalOptParams;
    private AlipayHashMap applicationParams;
}
