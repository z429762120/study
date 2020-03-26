package com.tool.collect.skytools.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tool.collect.skytools.graphql.dto.Dog;
import com.tool.collect.skytools.graphql.dto.UserInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/3/26 下午3:10
 **/
@Component
public class UserInfoResolver implements GraphQLResolver<UserInfo> {

    public List<Dog> getDogs(UserInfo userInfo,DataFetchingEnvironment env){
        List<Dog> dogs = new ArrayList<>();
        Dog dog1 = new Dog("小黑");
        Dog dog2 = new Dog("小花");
        dogs.add(dog1);
        dogs.add(dog2);
        return dogs;
    }

}
