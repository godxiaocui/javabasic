package org.example.springdata_jedis;

import org.example.springdata_jedis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


import javax.annotation.Resource;

@SpringBootTest
class SpringdataJedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testString(){
        //4.操作
        //存储
        redisTemplate.opsForValue().set("name6", "1111");
        // 获取数据
        String name = (String) redisTemplate.opsForValue().get("name6");
        System.out.println(name);
    }

    @Test
    void testUser() {
        // 插入数据

        redisTemplate.opsForValue().set("user:100", new User("Jack", 21));
        // 获取
        User name = (User)redisTemplate.opsForValue().get("user:100");
        System.out.println(name);
    }

    @Test
    void testHash() {
        // 插入hash数据
        stringRedisTemplate.opsForHash().put("user:2", "name", "Jack");
        stringRedisTemplate.opsForHash().put("user:2", "age", "21");

        // 获取
        Object o = stringRedisTemplate.opsForHash().get("user:2", "name");

        System.out.println(o);
    }

}
