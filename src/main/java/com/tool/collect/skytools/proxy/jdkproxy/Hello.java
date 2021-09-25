package com.tool.collect.skytools.proxy.jdkproxy;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/25 下午2:03
 **/
public class Hello implements HelloInterface {
	@Override
	public void sayHello() {
		System.out.println("你好");

	}
}
