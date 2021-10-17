package com.tool.collect.skytools.springbeanlifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/9 上午11:24
 **/
@Component
@Lazy
public class Dog implements Animal {

	public Dog() {
		System.out.println(this.getClass()+" : 执行构造函数");
	}


	@Override
	public String name() {
		return "小狗";
	}
}
