package com.tool.collect.skytools.demo;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/7/20 下午3:04
 **/
public class Test {
	public static void main(String[] args) {
		final HashBiMap<Object, Object> biMap = HashBiMap.create();
		biMap.put("key", "value");
		biMap.put("key", "value1");
		System.out.println(biMap);
		final BiMap<Object, Object> inverse = biMap.inverse();
		System.out.println(inverse);
	}
}
