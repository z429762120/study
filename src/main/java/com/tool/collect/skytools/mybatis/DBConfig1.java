package com.tool.collect.skytools.mybatis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午3:54
 **/
@Data
@ConfigurationProperties(prefix = "mysql.datasource.test1")
public class DBConfig1 {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
