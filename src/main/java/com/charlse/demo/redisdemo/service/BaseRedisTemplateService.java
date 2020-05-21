package com.charlse.demo.redisdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BaseRedisTemplateService {

    private static final Logger logger = LoggerFactory.getLogger(BaseRedisTemplateService.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void addValue(String key, String value){
        redisTemplate.opsForValue().append(key, value);
    }

    public String getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
