package com.hj.u.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by HeJun on 2018/11/2.
 */
@Component
public class RedisTemplateHandlerTmp {
    private Logger logger= LoggerFactory.getLogger(RedisTemplateHandlerTmp.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplateXml;
    public void testRedisTemplate(){
        ValueOperations<String, String> valueOperations=redisTemplateXml.opsForValue();
        valueOperations.set("hello2","22222world");
    }
}
