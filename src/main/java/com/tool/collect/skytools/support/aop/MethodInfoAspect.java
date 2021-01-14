package com.tool.collect.skytools.support.aop;


import com.tool.collect.skytools.support.aop.annotation.AspectInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * @Descriiption 测试
 * @Author bo
 * @Date 2019/9/29 下午1:59
 **/
@Component
@Aspect
@Slf4j
public class MethodInfoAspect {



    @Before("@annotation(aspectInfo)")
    public void aspectInfo(JoinPoint jp, AspectInfo aspectInfo) {

        final Object[] args = jp.getArgs();
        // TestController
        final Object target = jp.getTarget();

        // com.tool.collect.skytools.controller.TestController@32121140
        final Object aThis = jp.getThis();

        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        // String[2]{"name","person"}
        final String[] parameterNames = methodSignature.getParameterNames();

        //Class[2]{"class java.lang.String","class com.tool.collect.skytools.dto.Person"}
        final Class[] parameterTypes = methodSignature.getParameterTypes();

        //public void com.tool.collect.skytools.controller.TestController.testAspectInfo(java.lang.String,com.tool.collect.skytools.dto.Person)
        Method method = methodSignature.getMethod();

        //testAspectInfo
        final String methodName = method.getName();

        //class com.tool.collect.skytools.controller.TestController
        final Class<?> declaringClass = method.getDeclaringClass();
        //Parameter[2]{java.lang.String arg0,com.tool.collect.skytools.dto.Person arg1}
        final Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {

            //class java.lang.String   class com.tool.collect.skytools.dto.Person
            final Type parameterizedType = parameter.getParameterizedType();

            //class java.lang.String   class com.tool.collect.skytools.dto.Person
            final Class<?> type = parameter.getType();

            //arg0  arg1
            final String parameterName = parameter.getName();
        }
    }

    private HttpServletRequest getRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }

}
