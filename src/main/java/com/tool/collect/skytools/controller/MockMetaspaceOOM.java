package com.tool.collect.skytools.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/12/26 下午4:28
 **/
public class MockMetaspaceOOM {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            System.out.println("创建了"+ count++ +"个Car的子类");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (StringUtils.equals(method.getName(), "run")) {
                        System.out.println("汽车启动之前，进行安全检查....");
                    }
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            Car car = (Car)enhancer.create();
            car.run();
        }


    }

    static class Car{
        public void run() {
            System.out.println("汽车启动，开始行驶....");
        }
    }
}
