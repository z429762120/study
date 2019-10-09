package com.tool.collect.skytools.mapper1;

import com.tool.collect.skytools.dto.Person;
import org.apache.ibatis.annotations.Insert;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午4:00
 **/
public interface DemoMapper1 {

    @Insert("insert into person (username,age) values (#{username},#{age})")
    void insert(Person p);
}
