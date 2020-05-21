package com.charlse.demo.redisdemo.controller;

import com.charlse.demo.redisdemo.service.BaseRedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private BaseRedisTemplateService baseRedisTemplateService;

    @GetMapping("/testConnection")
    public String testRedisConnection(String key, String value){
        baseRedisTemplateService.addValue(key, value);
        return baseRedisTemplateService.getValue(key);
    }
}
