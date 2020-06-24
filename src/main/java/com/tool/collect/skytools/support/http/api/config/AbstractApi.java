package com.tool.collect.skytools.support.http.api.config;


import com.tool.collect.skytools.support.http.HttpClientManager;
import com.tool.collect.skytools.support.http.config.HttpClientProperties;
import com.tool.collect.skytools.support.utility.StringUtility;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;

import java.util.Map;

/**
 * @author Gnoll
 * @create 2017-07-01 13:38
 **/
public abstract class AbstractApi implements ApiProvider{
    protected static final Log log = LoggerFactory.make();
    protected static final String HTTP_PREFIX = "http://";
    protected static final String HTTPS_PREFIX = "https://";
    protected static final String DELIMITER = "/";

    protected HttpClientManager clientManager;
    protected HttpClientProperties properties;
    protected Map<String,String> apiMap;

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AbstractApi.class);

    @Override
    public void setHttpClientProperties(HttpClientProperties properties) {
        this.properties = properties;
        if(null != this.properties) {
            apiMap = properties.getUrlMap();
        }
    }

    @Override
    public void setHttpClientManager(HttpClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Override
    public void init() {}

    protected String getProperties(String name) {
        return apiMap.get(name);
    }

    protected StringBuilder makeUrl(String name) {
        StringBuilder builder = new StringBuilder(properties.getHost());
        String propertie = getProperties(name);
        if(!StringUtility.hasText(propertie)) return builder;
        if(propertie.indexOf(DELIMITER) == 0) {
            builder.append(propertie);
        }else{
            builder.append(DELIMITER).append(propertie);
        }
        return builder;
    }

    protected String makeHttpUrl(String name) {
        StringBuilder builder = makeUrl(name);
        if(builder.toString().indexOf(HTTP_PREFIX) == 0) return builder.toString();
        builder.insert(0,HTTP_PREFIX);
        logger.info("【获取到的http服务器的地址："+builder.toString()+"】");
        return builder.toString();
    }

    protected String makeHttpsUrl(String name) {
        StringBuilder builder = makeUrl(name);
        if(builder.toString().indexOf(HTTPS_PREFIX) == 0) return builder.toString();
        builder.insert(0,HTTPS_PREFIX);
        return builder.toString();
    }

    protected StringBuilder makeUrl4V3(String name,String machineVersion) {
        StringBuilder builder = new StringBuilder(properties.getHost());
        String properties = getProperties(name);
        if(!StringUtility.hasText(properties)) return builder;
        if(properties.indexOf(DELIMITER) == 0) {
            builder.append(properties);
        }else{
            builder.append(DELIMITER).append(properties);
        }
        return builder;
    }

    protected String makeHttpUrl4V3(String name,String machineVersion) {
        StringBuilder builder = makeUrl4V3(name,machineVersion);
        if(builder.toString().indexOf(HTTP_PREFIX) == 0) return builder.toString();
        builder.insert(0,HTTP_PREFIX);
        logger.info("【获取到的http服务器的地址："+builder.toString()+"】");
        return builder.toString();
    }

    protected String makeHttpsUrl4V3(String name,String machineVersion) {
        StringBuilder builder = makeUrl4V3(name,machineVersion);
        if(builder.toString().indexOf(HTTPS_PREFIX) == 0) return builder.toString();
        builder.insert(0,HTTPS_PREFIX);
        return builder.toString();
    }

}
