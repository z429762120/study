package com.tool.collect.skytools;

import com.tool.collect.skytools.dto.Person;
import com.tool.collect.skytools.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/4 下午5:48
 **/
@SpringBootTest(classes={SkytoolsApplication.class})
@RunWith(SpringRunner.class)
public class JunitTest  {
    @Autowired
    TestService testService;
    @Mock
    Person person;


    public JunitTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {
        Mockito.when(person.getAge()).thenReturn(11);
        Mockito.when(person.getUsername()).thenReturn("张三");
        System.out.println(person.toString());
    }



    public static void main(String[] args) {
        /**软引用*/
        SoftReference<Person> softReference = new SoftReference<>(new Person());
        /**弱引用*/
        WeakReference<Person> weakReference = new WeakReference<>(new Person());
        /**强因哟过引用*/
        Person person = new Person();
    }

}
