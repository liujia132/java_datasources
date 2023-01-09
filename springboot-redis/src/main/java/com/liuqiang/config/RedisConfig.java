package com.liuqiang.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * redisTemplate的配置序列化
 * @author liuqianh132
 *
 */
@EnableCaching
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 使用 GenericFastJsonRedisSerializer 替换默认序列化

        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();

        // 设置key和value的序列化规则

        redisTemplate.setKeySerializer(new GenericToStringSerializer<>(Object.class));

        redisTemplate.setValueSerializer(genericFastJsonRedisSerializer);

        // 设置hashKey和hashValue的序列化规则

        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));

        redisTemplate.setHashValueSerializer(genericFastJsonRedisSerializer);

        // 设置支持事物

        redisTemplate.setEnableTransactionSupport(true);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

}
