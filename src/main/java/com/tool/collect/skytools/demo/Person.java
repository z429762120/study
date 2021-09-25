package com.tool.collect.skytools.demo;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/15 下午1:52
 **/
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;

    private Map<String, Object> map = new HashMap<>();

    public static Person instance = new Person();

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    Map<String, Object> getMap() {
        return map;
    }

    void setMap(Map<String, Object> map) {
        this.map = map;
    }


    static Person getInstance() {
        return instance;
    }
}
