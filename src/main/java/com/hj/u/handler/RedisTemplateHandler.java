package com.hj.u.handler;

import com.hj.u.bean.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * Created by HeJun on 2018/11/2.
 */
@Component
public class RedisTemplateHandler {
    private Logger logger= LoggerFactory.getLogger(RedisTemplateHandler.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    public void testRedisTemplate(){
        ValueOperations<String, String> valueOperations=redisTemplate.opsForValue();
        valueOperations.set("hello1","11111world");
    }
}
