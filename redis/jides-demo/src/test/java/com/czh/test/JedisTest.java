package com.czh.test;

import com.czh.jedis.utils.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author godxiaocui
 * @date 2024/9/1415:51
 */
public class JedisTest {
    private Jedis jedis;
    //1. 建立连接

    @BeforeEach
    public void setUp() {
        //1. 建立连接
        jedis = JedisConnectionFactory.getJedisPool().getResource();
        //2.设置密码
        jedis.auth("123456");
        //3.选择库
        jedis.select(0);
    }

    @Test
    void testString(){
        //4.操作
        //存储
        String set = jedis.set("name", "godxiaocui");
        System.out.println(set);
        // 获取数据
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash() {
        // 插入hash数据
        jedis.hset("user:1", "name", "Jack");
        jedis.hset("user:1", "age", "21");

        // 获取
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    public void tearDown() {
        //5.关闭连接
        //判断是否是空指针
        if (jedis != null){
            jedis.close();
        }

    }



}
