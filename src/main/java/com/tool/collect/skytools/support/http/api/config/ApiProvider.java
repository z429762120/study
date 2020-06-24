package com.tool.collect.skytools.support.http.api.config;


import com.tool.collect.skytools.support.http.HttpClientManager;
import com.tool.collect.skytools.support.http.config.HttpClientProperties;

/**
 * @author Gnoll
 * @create 2017-07-01 12:23
 **/
public interface ApiProvider {
    void setHttpClientProperties(HttpClientProperties properties);
    void setHttpClientManager(HttpClientManager clientManager);
    void init();
}
