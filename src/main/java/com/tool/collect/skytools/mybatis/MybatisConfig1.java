package com.tool.collect.skytools.mybatis;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/9 下午2:06
 **/
@Configuration
@EnableConfigurationProperties(value = DBConfig1.class)
@MapperScan(basePackages = {"com.tool.collect.skytools.mapper1","com.tool.collect.skytools.mybatis.dao"},sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class MybatisConfig1 {
    @Autowired
    DBConfig1 dbConfig;

    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "mysql.datasource.test1")
    public DataSource testDataSource(DBConfig1 dbConfig) throws SQLException {
        return DataSourceBuilder.create().url(dbConfig.getUrl()).driverClassName(dbConfig.getDriverClassName())
                .username(dbConfig.getUsername())
                .password(dbConfig.getPassword())
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
