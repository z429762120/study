package com.tool.collect.skytools.support.springExtension.Interceptor;


import com.tool.collect.skytools.support.springExtension.resolver.CurrentUserMethodArgumentResolver;
import com.tool.collect.skytools.support.springExtension.resolver.RequestModelMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Gnoll
 * @create 2017-06-21 10:27
 **/
@Configuration
public class AdapterConfiguration extends WebMvcConfigurerAdapter{
    /**
     * 参数映射解析器
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new RequestModelMethodArgumentResolver());
        argumentResolvers.add(new CurrentUserMethodArgumentResolver());
    }
}
