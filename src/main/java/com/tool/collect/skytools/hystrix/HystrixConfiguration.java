package com.tool.collect.skytools.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/7/6 下午3:56
 **/
@Configuration
public class HystrixConfiguration {
	@Bean
	public ServletRegistrationBean indexServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
		registration.addUrlMappings("/hystrix.stream");
		return registration;
	}
}
