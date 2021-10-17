package com.tool.collect.skytools.springbeanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/9 上午11:43
 **/
@Configuration
@ComponentScan(value = "com.tool.collect.skytools.springbeanlifecycle")
public class AppConfig {

	@Bean(name = "mySpringPerson",initMethod = "initMethod",destroyMethod = "destroyMethod")
	public MySpringPerson MySpringPerson() {
		return new MySpringPerson();
	}
}
