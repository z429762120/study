package com.tool.collect.skytools.support.async;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gnoll
 * @create 2017-07-12 13:58
 **/
@Data
@ConfigurationProperties(prefix = "appserver.async")
public class AsyncAutoProperties {
    private boolean enabled = false;
    private List<ExecutorProperties> executors = new ArrayList<>();
}
