package com.tool.collect.skytools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=
        {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SkytoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkytoolsApplication.class, args);
    }

}
