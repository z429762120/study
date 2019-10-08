package com.tool.collect.skytools.support.async;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gnoll
 * @create 2017-07-12 12:18
 **/
@Data
public class ExecutorProperties {
    private String qualifier;          // 名称
    private String threadNamePrefix;   // 线程前缀名
    private Integer corePoolSize;      // 线程数量
    private Integer maxPoolSize;       // 最大线程数量
    private Integer queueCapacity;     // 等待容量

    public List<String> ignore(){
        List<String> list = new ArrayList<>();
        list.add("qualifier");
        list.add("class");
        return list;
    }
}
