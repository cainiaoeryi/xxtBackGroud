package com.my.xxtbackgroud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class redisStringTemplate {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String age = ops.get("name");
        System.out.println(age);

    }
}
