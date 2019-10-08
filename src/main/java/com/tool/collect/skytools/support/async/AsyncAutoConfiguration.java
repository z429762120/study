package com.tool.collect.skytools.support.async;


import com.tool.collect.skytools.support.utility.EntityPropertyUtility;
import com.tool.collect.skytools.support.utility.ReflectionUtility;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Gnoll
 * @create 2017-07-12 11:52
 **/
@EnableAsync
@Configuration
@EnableConfigurationProperties(AsyncAutoProperties.class)
@ConditionalOnProperty(value = "appserver.async.enabled", havingValue = "true")
public class AsyncAutoConfiguration implements ApplicationContextAware, InitializingBean {
    private final AsyncAutoProperties asyncAutoProperties;
    private GenericApplicationContext applicationContext;

    public AsyncAutoConfiguration(AsyncAutoProperties asyncAutoProperties) {
        this.asyncAutoProperties = asyncAutoProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        asyncAutoProperties.getExecutors().forEach(this::registerExecutor);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof GenericApplicationContext) {
            this.applicationContext = (GenericApplicationContext) applicationContext;
        }
    }

    private void registerExecutor(ExecutorProperties properties) {
        PropertyDescriptor[] propertyDescriptors = EntityPropertyUtility.getPropertyDescriptors(ExecutorProperties.class);
        Map<String, Object> map = new HashMap<>();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            if (properties.ignore().contains(descriptor.getName())) continue;
            Object value = ReflectionUtility.invokeMethod(descriptor.getReadMethod(), properties);
            if (null == value) continue;
            map.put(descriptor.getName(), value);
        }

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(ThreadPoolTaskExecutor.class);
        beanDefinition.getPropertyValues().addPropertyValues(map);
        beanDefinition.setSynthetic(true);
        applicationContext.registerBeanDefinition(properties.getQualifier(), beanDefinition);
    }

    @Bean
    public Executor sql() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(1000);    //add by yangran 2018.03.14 调大队列数
        executor.setThreadNamePrefix("Async-sql-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
