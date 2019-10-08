package com.tool.collect.skytools.support.http.config;

import lombok.Data;

import java.util.Map;

/**
 * @author Gnoll
 * @create 2017-06-23 13:52
 **/
@Data
public class HttpClientProperties {
    private String host;
    private String v3Host;
    private Integer maxPreRoute;
    private Map<String,String> urlMap;
}
