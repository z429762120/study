package com.tool.collect.skytools.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午6:52
 **/
@Data
@Accessors(chain = true)
public class Person {
    @NotEmpty(message = "明知不能为空")
    private String username;
    private Integer age;
    private Byte leaf;
}
