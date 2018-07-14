package com.digvijayb.spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisClient {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("redis-client.spring.xml");

        final RedisTemplate redisTemplate = context.getBean("redisTemplate",RedisTemplate.class);
        StringRedisTemplate stringRedisTemplate = context.getBean(StringRedisTemplate.class);
        String hash = "employee";
        String hkey1 = "1";
        String hvalue1 = "Jon";
        String hkey2 = "2";
        String hvalue2 = "June";
        HashOperations hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.putIfAbsent(hash, hkey1, hvalue1);
        hashOperations.putIfAbsent(hash, hkey2, hvalue2);
        Object valueObj = hashOperations.get(hash, hkey1);
        System.out.println("valueObj = " + valueObj);


    }


}
