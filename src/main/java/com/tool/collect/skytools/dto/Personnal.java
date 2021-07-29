package com.tool.collect.skytools.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午6:52
 **/
@Data
@NoArgsConstructor
//@Accessors(chain = true)
public class Personnal {
    private String username;
    private Integer age;
    private Byte leaf;

    public Personnal(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
