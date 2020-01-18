package com.tool.collect.skytools.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/1/16 下午6:39
 **/
@Component
@PropertySource(value = "classpath:kafka.properties")
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaConfiguration {
    private String bootstrapServers;
    private ProducerConfiguration producer;
    private ConsumerConfiguration consumer;

}
