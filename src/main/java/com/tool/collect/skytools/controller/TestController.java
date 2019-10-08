package com.tool.collect.skytools.controller;

import com.tool.collect.skytools.support.aop.annotation.IpIntercept;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/8 下午2:28
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @IpIntercept(value = {"192.168.0.1"})
    @PostMapping("testIpIntercept")
    public String testIpIntercept(@NotBlank String name) {
        System.out.println();
        return "success";
    }
}
