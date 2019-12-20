package com.tool.collect.skytools.mapper1;

import com.tool.collect.skytools.dto.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午4:00
 **/
public interface DemoMapper1 {

    @Insert("insert into person (username,age) values (#{username},#{age})")
    void insert(Person p);

    @Select("select * from person where username=#{name}")
    List<Person> selectByName(String name);
}
