package com.liuqiang.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 接口测试
 */
@RestController
@RequestMapping("/index")
public class RedidController {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 实现网站的访问次数功能
     * @return
     */
    @GetMapping("/redis01")
    public String redis01(){
        Long view = redisTemplate.opsForValue().increment("view");

        return "springboot running 你已经访问该网站:"+ view+"次了";
    }
    @GetMapping("/redis02")
    public Integer redis02(){
        redisTemplate.opsForValue().set("iphone","13259215528");

        return 0;

    }
}
