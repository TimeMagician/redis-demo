package com.charlse.demo.redisdemo.service;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class BaseRedisTemplateService {

    private static final Logger logger = LoggerFactory.getLogger(BaseRedisTemplateService.class);

    @Autowired
    private RedisTemplate redisTemplate;

    public void addValue(String key, String value){
        redisTemplate.opsForValue().append(key, value);
    }

    public String getValue(String key){
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate.opsForValue().get(key).toString();
    }
}
