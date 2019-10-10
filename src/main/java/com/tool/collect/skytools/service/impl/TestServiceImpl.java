package com.tool.collect.skytools.service.impl;

import com.alibaba.fastjson.JSON;
import com.tool.collect.skytools.dto.JsonTestDTO;
import com.tool.collect.skytools.dto.Person;
import com.tool.collect.skytools.mapper1.DemoMapper1;
import com.tool.collect.skytools.mapper2.DemoMapper2;
import com.tool.collect.skytools.service.TestService;
import com.tool.collect.skytools.support.utility.JsonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午6:58
 **/
@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    DemoMapper1 demoMapper1;
    @Autowired
    DemoMapper2 demoMapper2;

    @Override
    public void multiDataSourceTest(int i) {
        Person person = new Person();
        person.setAge(11);
        person.setUsername("张三");
        demoMapper1.insert(person);
        demoMapper2.insert(person);
        int a = 1 / i;
    }

    public static void main(String[] args) {
        JsonTestDTO j = new JsonTestDTO();
        j.set_name("11");
        j.setAddress("ddidid");
        j.setNum(1.2d);

        String jsonstr2 = "{\n" +
                "  \"Address\" : \"ddidid\",\n" +
                "  \"nUm\" : 1.2,\n" +
                "  \"bb\" : 1.20999999999999996447286321199499070644378662109375,\n" +
                "  \"_name\" : \"11\"\n" +
                "}";
        System.out.println(JsonUtility.toObject(jsonstr2,JsonTestDTO.class));
        System.out.println(JsonUtility.toString(j));

    }

}
