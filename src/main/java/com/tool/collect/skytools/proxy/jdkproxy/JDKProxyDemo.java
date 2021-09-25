package com.tool.collect.skytools.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/25 下午2:04
 **/
public class JDKProxyDemo {
	public static void main(String[] args) {
		HelloInterface hello = new Hello();
		ProxyInvocationhandler invocationhandler = new ProxyInvocationhandler(hello);

		final HelloInterface helloProxy = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), invocationhandler);
		helloProxy.sayHello();
	}
}
