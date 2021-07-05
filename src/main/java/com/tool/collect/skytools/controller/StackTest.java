package com.tool.collect.skytools.controller;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Descriiption
 * @Author bo
 * @Date 2021/4/15 上午10:10
 **/
public class StackTest {

    public static void main(String[] args) {
        Map map = new TreeMap();
        map.put(1, 11);
        System.out.println(map.remove(1));
        System.out.println(map);
    }
}
