package com.tool.collect.skytools.service.impl;

import com.tool.collect.skytools.dto.Person;
import com.tool.collect.skytools.mapper1.DemoMapper1;
import com.tool.collect.skytools.mapper2.DemoMapper2;
import com.tool.collect.skytools.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
