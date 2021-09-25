package com.tool.collect.skytools.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/25 下午1:56
 **/
public class ProxyInvocationhandler implements InvocationHandler {
	private Object object;

	ProxyInvocationhandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("动态代理增强逻辑，before...");
		final Object o = method.invoke(object, args);
		System.out.println("动态代理增强逻辑，after...");
		return o;
	}
}
