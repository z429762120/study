package com.tool.collect.skytools.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/25 下午2:19
 **/
public class CglibProxyDemo {
	public static void main(String[] args) {

		final Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloService.class);
		enhancer.setCallback(new MyMethodInterceptor());
		final HelloService helloService = (HelloService) enhancer.create();
		helloService.sayHello();

	}
}
