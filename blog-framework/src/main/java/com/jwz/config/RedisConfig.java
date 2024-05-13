package com.jwz.config;

import com.jwz.utils.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/13
 * @annotation Redis序列化配置类,使用fastJson进行序列化与反序列化
 */

@Configuration
public class RedisConfig {

    /**
     * @description: Hashkey, key序列化成String, HashValue,value序列化成Json
     * @param connectionFactory RedisConnectionFactory connectionFactory 负责创建Redis连接
     * @return:  
     */
    @Bean
    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        FastJsonRedisSerializer fastJsonSerializer = new FastJsonRedisSerializer(Object.class);

        //  使用StringRedisSerializer序列化反序列化redis的key值, FastJson序列化value
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(fastJsonSerializer);

        // Hash的key也采用StringRedisSerializer序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(fastJsonSerializer);

        template.afterPropertiesSet(); //用于完成 RedisTemplate 的初始化。初始化完成序列化的方法

        return template;

    }

}
