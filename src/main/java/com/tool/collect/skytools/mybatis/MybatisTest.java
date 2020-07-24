package com.tool.collect.skytools.mybatis;

import com.tool.collect.skytools.mybatis.dao.PersonMapper;
import com.tool.collect.skytools.mybatis.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/7/23 下午4:51
 **/
public class MybatisTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig1.class);
        PersonMapper personMapper = (PersonMapper)context.getBean(PersonMapper.class);
        List<Person> p = personMapper.queryByIds(Arrays.asList(1));
        System.out.println(p);
    }
}
