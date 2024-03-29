package com.tool.collect.skytools.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午6:52
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String username;
    private Integer age;
    private Byte leaf;
    public Person(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
