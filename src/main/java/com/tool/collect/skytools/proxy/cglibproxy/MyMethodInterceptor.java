package com.tool.collect.skytools.proxy.cglibproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/25 下午2:17
 **/
public class MyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("前置增强...");
		final Object o1 = methodProxy.invokeSuper(o, objects);
		System.out.println("后置增强...");
		return o1;
	}
}
