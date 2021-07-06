package com.tool.collect.skytools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.archaius.ArchaiusAutoConfiguration;


@SpringBootApplication(exclude=
        {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, ArchaiusAutoConfiguration.class})
//@EnableFeignClients/*(defaultConfiguration = MyFeignClientsConfiguration.class)*/
public class SkytoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkytoolsApplication.class, args);
    }

}
