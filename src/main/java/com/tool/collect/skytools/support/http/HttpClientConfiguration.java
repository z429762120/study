package com.tool.collect.skytools.support.http;


import com.tool.collect.skytools.support.http.api.annotation.Api;
import com.tool.collect.skytools.support.http.api.annotation.ApiScan;
import com.tool.collect.skytools.support.http.api.config.ApiProvider;
import com.tool.collect.skytools.support.http.config.HttpClientProperties;
import com.tool.collect.skytools.support.http.config.HttpManagerProperties;
import org.apache.http.HttpHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Gnoll
 * @create 2017-06-23 11:32
 **/
@Configuration
@ConditionalOnProperty(prefix = "appserver.http", name = "enabled")
@EnableConfigurationProperties(HttpManagerProperties.class)
@ApiScan("com.aimymusic.appserver.http")
public class HttpClientConfiguration {

    private HttpManagerProperties managerProperties;
    @Autowired(required = false)
    private List<ApiProvider> apiProviders;

    public HttpClientConfiguration(HttpManagerProperties managerProperties) {
        this.managerProperties = managerProperties;
    }

    @Bean
    public HttpClientManager httpClientManager() {
        HttpClientManager httpClientManager = new HttpClientManager(managerProperties);
        Map<String, HttpClientProperties> clientProperties = managerProperties.getClientProperties();
        if(!CollectionUtils.isEmpty(clientProperties)) {
            clientProperties.forEach((s, httpClientProperties) -> {
                HttpHost httpHost = HttpHost.create(httpClientProperties.getHost());
                httpClientManager.setMaxPerRoute(httpHost,httpClientProperties.getMaxPreRoute());
                ApiProvider apiProvider = findApiProvider(s);
                if(null != apiProvider) {
                    apiProvider.setHttpClientManager(httpClientManager);
                    apiProvider.setHttpClientProperties(httpClientProperties);
                    apiProvider.init();
                }
            });
        }
        return httpClientManager;
    }

    private ApiProvider findApiProvider(String name) {
        if(CollectionUtils.isEmpty(apiProviders)) return null;
        for(ApiProvider apiProvider:apiProviders) {
            Api annotation = AnnotationUtils.findAnnotation(apiProvider.getClass(), Api.class);
            String value = annotation.value();
            if(name.equals(value)) return apiProvider;
        }
        return null;
    }
}
