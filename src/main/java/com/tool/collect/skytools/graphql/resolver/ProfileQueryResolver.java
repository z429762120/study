package com.tool.collect.skytools.graphql.resolver;

import com.alibaba.fastjson.JSON;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tool.collect.skytools.graphql.dto.UserInfo;
import com.ywkj.base.bean.ResponseResult;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/3/26 上午10:09
 **/
@Slf4j
@Component
public class ProfileQueryResolver implements GraphQLQueryResolver {

    RestTemplate restTemplate = new RestTemplate();

    /**
     * 测试在登录之后获取返回的token，通过token获取用户信息
     * @param env
     * @return
     */
    public UserInfo userInfo(String token,DataFetchingEnvironment env) {
        log.info("登录返回的token={}", token);
        String url = "http://profile.ypzdw.cn/profile/person/userInfo?token=" + token;
        ResponseResult response = restTemplate.getForObject(url, ResponseResult.class);
        if (!response.isSuccess()) {
            return JSON.parseObject(JSON.toJSONString(response.getData()), UserInfo.class);
        } else {
            log.error("获取用户信息失败，errorMsg={}", response.getMessage());
            throw new RuntimeException("获取用户信息失败");
        }

    }
}
