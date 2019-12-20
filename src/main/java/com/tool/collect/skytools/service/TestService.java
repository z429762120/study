package com.tool.collect.skytools.service;

import com.tool.collect.skytools.dto.Person;

import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午6:57
 **/
public interface TestService {
    /**
     * 分布式事务
     * @param i
     */
    void multiDataSourceTest(int i);

    List<Person> findByName(String name);

    void testJvm();
}
