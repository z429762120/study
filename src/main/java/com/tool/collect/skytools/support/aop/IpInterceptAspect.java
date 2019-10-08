package com.tool.collect.skytools.support.aop;


import com.tool.collect.skytools.support.aop.annotation.IpIntercept;
import com.tool.collect.skytools.support.utility.HostAddressUtility;
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

/**
 * @Descriiption ip拦截
 * @Author bo
 * @Date 2019/9/29 下午1:59
 **/
@Component
@Aspect
@Slf4j
public class IpInterceptAspect {



    @Before("@annotation(ipIntercept)")
    public void invalidIpAddress(JoinPoint jp, IpIntercept ipIntercept) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();

        if (method.isAnnotationPresent(IpIntercept.class)) {
            IpIntercept an = method.getAnnotation(IpIntercept.class);
            String[] interceptIps = an.value();
            if (interceptIps.length > 0) {
                HttpServletRequest request = getRequest();
                String ip = HostAddressUtility.getIpAddress(request);
                log.info("请求uri={},请求ip={}", request.getRequestURI(), ip);
                System.out.println(request.getRequestURL());
                System.out.println(request.getServletPath());
            }
        }


    }


    private HttpServletRequest getRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }


    private static Boolean filtStr(String network, String maskIp) {
        //首先将网段转换为10进制数
        String[] networks = network.split("\\.");
        long networkIp = Long.parseLong(networks[0]) << 24 |
                Long.parseLong(networks[1]) << 16 |
                Long.parseLong(networks[2]) << 8 |
                Long.parseLong(networks[3]);

        //取出网络位数
        int netCount = Integer.parseInt(maskIp.replaceAll(".*/", ""));
        //这里实际上通过CIDR的网络号转换为子网掩码
        int mask = 0xFFFFFFFF << (32 - netCount);

        //再将验证的ip转换为10进制数
        String testIp = maskIp.replaceAll("/.*", "");
        String[] ips = testIp.split("\\.");
        long ip = Long.parseLong(ips[0]) << 24 |
                Long.parseLong(ips[1]) << 16 |
                Long.parseLong(ips[2]) << 8 |
                Long.parseLong(ips[3]);

        //将网段ip和验证ip分别和子网号进行&运算之后，得到的是网络号，如果相同，说明是同一个网段的
        return (networkIp & mask) == (ip & mask);
    }

    public static void main(String[] args) {
        String maskIp = "192.168.0.0/24";
        String network = "192.168.0.111";
        String network1 = "192.168.1.162";
        System.out.println(IpInterceptAspect.filtStr(network,maskIp));
        System.out.println(IpInterceptAspect.filtStr(network1,maskIp));
    }

}
