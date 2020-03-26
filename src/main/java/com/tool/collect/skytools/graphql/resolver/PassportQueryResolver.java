package com.tool.collect.skytools.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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
public class PassportQueryResolver implements GraphQLQueryResolver {

    RestTemplate restTemplate = new RestTemplate();

    public String smsLogin(String mobileNumber,String smsCode) {
        return "14aaf75c-9693-46d8-a9ce-4b1bc7d11450";
    }
}
