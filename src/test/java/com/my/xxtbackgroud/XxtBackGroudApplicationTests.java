package com.my.xxtbackgroud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
class XxtBackGroudApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void set(){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",41);
    }
    @Test
    void get(){
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("age");
        System.out.println(age);
    }

}
