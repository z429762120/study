package com.tool.collect.skytools.springbeanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/9 下午1:49
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
		if (o instanceof MySpringPerson) {
			System.out.println("【" + o.getClass().getSimpleName() + " 调用 BeanPostProcessor 的 postProcessBeforeInitialization 参数" + o.getClass().getSimpleName() +","+ s+"】");
		}
		return o;
	}

	@Override
	public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
		if (o instanceof MySpringPerson) {
			System.out.println("【" + o.getClass().getSimpleName() + " 调用 BeanPostProcessor 的 postProcessAfterInitialization 参数" + o.getClass().getSimpleName() +","+s+"】");
		}
		return o;
	}
}
