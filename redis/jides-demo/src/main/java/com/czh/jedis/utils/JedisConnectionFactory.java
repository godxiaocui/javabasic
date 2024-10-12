package com.czh.jedis.utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author godxiaocui
 * @date 2024/9/1415:59
 */
public class JedisConnectionFactory {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        //最小空闲连接
        poolConfig.setMinIdle(0);
        //连接池用完等待多久
        poolConfig.setMaxWaitMillis(1000);
        // 创建连接池对象，参数：连接池配置、服务端ip、服务端端口、超时时间、密码
        jedisPool = new JedisPool(poolConfig, "124.220.77.234", 6379, 1000, "123456");
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }
}
