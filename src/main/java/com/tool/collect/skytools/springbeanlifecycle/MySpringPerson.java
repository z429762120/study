package com.tool.collect.skytools.springbeanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Getter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/9 上午11:28
 **/
//@Component
public class MySpringPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	Animal animal;
	@Getter
	private String name;

	private BeanFactory beanFactory;

	private ApplicationContext context;

	public MySpringPerson() {
		System.out.println(this.getClass().getSimpleName() + "调用构造方法");
	}

	@Autowired
	public void setAnimal(Animal animal) {
		System.out.println("MySpringPerson填充annimal属性");
		this.animal = animal;
	}

	public void initMethod() {
		System.out.println("MySpringPerson执行@Bean.initMethod");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("MySpringPerson执行@postConstruct");
	}

	/**
	 * 接口BeanNameAware的方法
	 * @param s
	 */
	@Override
	public void setBeanName(String s) {
		System.out.println("【" + this.getClass().getSimpleName() + " 调用 BeanNameAware 的 setBeanName ");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("【" + this.getClass().getSimpleName() + " 调用 BeanFactoryAware 的 setBeanFactory ");
		this.beanFactory = beanFactory;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("【" + this.getClass().getSimpleName() + " 调用 ApplicationContextAware 的 setApplicationContext ");
		this.context = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【" + this.getClass().getSimpleName() + " 调用 InitializingBean 的 afterPropertiesSet ");
		this.name = "张三";
	}


	/**
	 * Person
	 */
	@Override
	public void use() {
		System.out.println("调用MySpringPerson的use方法");
	}


	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy 执行");
	}

	public void destroyMethod() {
		System.out.println("MySpringPerson执行@Bean.destroy");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("【" + this.getClass().getSimpleName() + " 调用 DisposableBean 的 destroy ");
	}

}
