package com.tool.collect.skytools.springbeanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/9 上午11:44
 **/
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		final MySpringPerson springPerson =  ctx.getBean(MySpringPerson.class);
		springPerson.use();
		ctx.close();
	}
}
