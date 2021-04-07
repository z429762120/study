package com.tool.collect.skytools.hystrix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Descriiption
 * @Author bo
 * @Date 2021/4/6 下午5:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    private Long productId;
    private String name;
}
