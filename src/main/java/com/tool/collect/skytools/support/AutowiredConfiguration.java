package com.tool.collect.skytools.support;


import com.tool.collect.skytools.support.encrypt.EncryptorUtility;
import com.tool.collect.skytools.support.generator.CodeGenerator;
import com.tool.collect.skytools.support.generator.IdGenerator;
import com.tool.collect.skytools.support.utility.BeanValidatorUtility;
import com.tool.collect.skytools.support.utility.HostAddressUtility;
import com.tool.collect.skytools.support.utility.I18nMessageUtility;
import com.tool.collect.skytools.support.utility.StringUtility;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import java.net.InetAddress;
import java.net.SocketException;
import java.util.Set;

/**
 * 一些需要初始化加载的Bean
 *
 * @author Gnoll
 * @create 2017-07-03 10:25
 **/
@Configuration
public class AutowiredConfiguration {
    private static final Log LOG = LoggerFactory.make();
    @Autowired
    private Environment environment;

    /**
     * ID生成工具
     * @return
     * @throws SocketException
     */
    @Bean
    public IdGenerator idGenerator() throws SocketException {
        String ignoreHost = environment.getProperty("appserver.autowired.id-generator");
        if (StringUtility.hasText(ignoreHost)) {
            return new IdGenerator(hostToLong());
        }
        return new IdGenerator(HostAddressUtility.localHostAfterTwo());
    }

    /**
     * 国际化
     *
     * @param messageSource
     * @return
     */
    @Bean
    public I18nMessageUtility i18nMessageUtility(MessageSource messageSource) {
        return new I18nMessageUtility(messageSource);
    }


    /**
     * 订单编号生成
     *
     * @return
     * @throws SocketException
     */
    @Bean
    public CodeGenerator orderGenerator() throws SocketException {
        String ignoreHost = environment.getProperty("appserver.autowired.id-generator");
        if(StringUtility.hasText(ignoreHost)) {
            return new CodeGenerator(hostToLong());
        }
        return new CodeGenerator(HostAddressUtility.localHostAfterTwo());
    }

    private long hostToLong() throws SocketException {
        String ignoreHost = environment.getProperty("appserver.autowired.id-generator");
        if (StringUtility.hasText(ignoreHost)) {
            String[] ignoreHosts = ignoreHost.split(",");
            Set<InetAddress> hosts = HostAddressUtility.multiGetLocalAddress(ignoreHosts);
            if (!CollectionUtils.isEmpty(hosts)) {
                long lastTwoHost = HostAddressUtility.localHostAfterTwo((InetAddress) hosts.toArray()[0]);
                return lastTwoHost;
            }
        }
        return HostAddressUtility.localHostAfterTwo();
    }

    /**
     * MD5，SHA1，SHA256，SHA384，SHA512
     * @return
     */
    @Bean
    public EncryptorUtility encryptorUtility() {
        String encryptor = environment.getProperty("appserver.autowired.encryptor");
        if(StringUtility.hasText(encryptor)) {
            return new EncryptorUtility(encryptor);
        }
        return new EncryptorUtility("");
    }


    /*@Bean
    public RedisLock redisLock(RedisTemplate redisTemplate) {
        return new RedisLock(redisTemplate);
    }

    @Bean
    public CacheLockAspect cacheLockAspect() {
        return new CacheLockAspect();
    }
    */

    @Bean
    public BeanValidatorUtility beanValidatorUtility(ApplicationContext context) {
        return new BeanValidatorUtility(context);
    }
}
