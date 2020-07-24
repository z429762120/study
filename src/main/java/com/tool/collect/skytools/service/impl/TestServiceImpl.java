package com.tool.collect.skytools.service.impl;

import com.tool.collect.skytools.dto.Person;
import com.tool.collect.skytools.service.TestService;
import com.tool.collect.skytools.support.model.PropertyFilterInfo;
import com.tool.collect.skytools.support.utility.JsonUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午6:58
 **/
@Slf4j
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Override
    public void multiDataSourceTest(int i) {
        Person person = new Person();
        person.setAge(11);
        person.setUsername("张三");
        int a = 1 / i;
        System.out.println("测试多数据源分布式事务执行完毕");
    }

    @Override
    public void testJvm() {
        byte[] array1 = new byte[1024 * 1024];
        byte[] array2 = new byte[1024 * 1024];
        byte[] array3 = new byte[1024 * 1024];
        byte[] array4 = new byte[1024 * 1024];
        byte[] array5 = new byte[1024 * 1024];
        byte[] array6 = new byte[1024 * 1024];
        log.info(Thread.currentThread().getName()+"---> 产生6M的数据！！！");
    }


    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(11);
        p.setUsername("sss");
        PropertyFilterInfo filterInfo = new PropertyFilterInfo("age");
        System.out.println(JsonUtility.toString(p));
        System.out.println(JsonUtility.toString(p,filterInfo));


    }

}
