package com.tool.collect.skytools.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Assert;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/7/6 上午9:21
 **/
public class CommandUsingRequestCache extends HystrixCommand<String> {
	private String value;

	CommandUsingRequestCache( String value) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
		this.value = value;
	}

	@Override
	protected String run() throws Exception {
		System.out.println("run方法被执行"+value);
		return "hello" + value;
	}

	@Override
	protected String getCacheKey() {
		return value;
	}

	public static void main(String[] args) {
		//通常可以用一个filter拦截器负责HystrixRequestContext的初始化和关闭
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
		try {
			Assert.assertEquals(new CommandUsingRequestCache("李雷").execute(), "hello李雷");
			Assert.assertEquals(new CommandUsingRequestCache("李雷").execute(), "hello李雷");
			Assert.assertEquals(new CommandUsingRequestCache("韩梅梅").execute(), "hello韩梅梅");
		}
		finally {
			context.shutdown();

		}
	}
}
