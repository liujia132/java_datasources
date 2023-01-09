package com.liuqiang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * redis中设置name
     */
    @Test
    public void setName(){
        redisTemplate.opsForValue().set("name","解鲁瑶");
    }
    /**
     * redis中获取name
     */
    @Test
    public void getName(){
        String name = redisTemplate.opsForValue().get("name");
        String view = redisTemplate.opsForValue().get("view");
        System.out.println("redis中获取到的name为:"+name);
        System.out.println("redis中获取到的view为:"+view);

    }

    /**
     * 测试累加功能
     */
    @Test
    public void redis01(){
        Long view = redisTemplate.opsForValue().increment("view");

        System.out.println("你已经访问该网站:"+view+"次了");
    }




}
