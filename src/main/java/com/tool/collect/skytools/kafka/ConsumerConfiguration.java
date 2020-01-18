package com.tool.collect.skytools.kafka;

import lombok.Data;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/1/16 下午7:33
 **/
@Data
public class ConsumerConfiguration {
    private String groupId;
    private boolean autoCommitEnable;
}
