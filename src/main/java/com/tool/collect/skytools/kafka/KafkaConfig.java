package com.tool.collect.skytools.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Descriiption 自定义kafka配置
 * @Author bo
 * @Date 2020/1/16 下午6:58
 **/
//@Configuration
public class KafkaConfig {
    @Autowired
    private KafkaConfiguration configuration;
    @Autowired
    MyKafkaProducerListenner myKafkaProducerListenner;



    /**
     * @Description: 生产者的配置
     * @Author:杨攀
     * @Since: 2019年7月10日下午1:41:06
     * @return
     */
    public Map<String, Object> producerConfigs() {

        Map<String, Object> props = new HashMap<>();
        // 集群的服务器地址
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, configuration.getBootstrapServers());
        //  消息缓存
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, configuration.getProducer().getBufferMemory());
        props.put(ProducerConfig.ACKS_CONFIG, configuration.getProducer().getAcks());
        // 生产者空间不足时，send()被阻塞的时间，默认60s
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 6000);
        // 生产者重试次数
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        // 指定ProducerBatch（消息累加器中BufferPool中的）可复用大小
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,  4096);
        // 生产者会在ProducerBatch被填满或者等待超过LINGER_MS_CONFIG时发送
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        // key 和 value 的序列化
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        return props;
    }

    /**
     * @Description: 生产者工厂
     * @Author:杨攀
     * @Since: 2019年7月10日下午2:10:04
     * @return
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /**
     * @Description: KafkaTemplate
     * @Author:杨攀
     * @Since: 2019年7月10日下午2:10:47
     * @return
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory());
        kafkaTemplate.setProducerListener(myKafkaProducerListenner);
        return kafkaTemplate;
    }


    // ------------------------------------------------------------------------------------------------------------

    /**
     * @Description: 消费者配置
     * @Author:杨攀
     * @Since: 2019年7月10日下午1:48:36
     * @return
     */
    public Map<String, Object> consumerConfigs() {

        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, configuration.getBootstrapServers());
        // 消费者组
        props.put(ConsumerConfig.GROUP_ID_CONFIG, configuration.getConsumer().getGroupId());
        // 自动位移提交
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, configuration.getConsumer().isAutoCommitEnable());
        // 自动位移提交间隔时间，自动提交offset有效
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 6000);
        // 消费组失效超时时间
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10000);
        // 位移丢失和位移越界后的恢复起始位置
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        //每次poll()拉取消息条数
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 3);
        //每次poll之间的最大时间间隔，如果超过这个时间还没有提交偏移量，kafka会认为消费失败，
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 3000);
        // key 和 value 的反序列化
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");

        return props;
    }

    /**
     * @Description: 消费者工厂
     * @Author:杨攀
     * @Since: 2019年7月10日下午2:14:13
     * @return
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    /**
     * @Description: kafka 监听容器工厂
     * @Author:杨攀
     * @Since: 2019年7月10日下午2:50:44
     * @return
     */
    @Bean("defaultKafkaListenerContainerFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        // 设置消费者工厂
        factory.setConsumerFactory(consumerFactory());
        // 根据topic分区来决定你的线程数量, 比如：两个@KafkaListener1 @KafkaListener2， concurrency=5， topic 分区数=3 时
        // 具体情况如下： 其中一个@KafkaListener会有启动两个消费者（两个线程） 分配到两个分区 另一个@KafkaListener会启动一个消费者（一个线程）
        // 分配到一个分区; 总线程数只会等于分区数3而不会等于5； 当其中@KafkaListener1 挂掉时，会触发消费者再均衡，@KafkaListener2开启三个线程，
        // 分配得到三个分区
        factory.setConcurrency(1);
        //设置批量消费 spring-kafka 1.1之后支持
        factory.setBatchListener(true);
        //是否开启kafka消费者自动监听,false需要手动开启
        //factory.setAutoStartup(false);
        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
        //再均衡监听器
        factory.getContainerProperties().setConsumerRebalanceListener(new MyConsumerRebalanceListener());
        return factory;
    }
}
