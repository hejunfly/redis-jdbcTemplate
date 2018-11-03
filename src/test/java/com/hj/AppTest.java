package com.hj;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application*.xml"})
public class AppTest 
{
    private Logger logger= LoggerFactory.getLogger(AppTest.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }
    @Test
    public void testRedisTemplate(){
        ValueOperations<String, String> valueOperations=redisTemplate.opsForValue();
        valueOperations.set("hello1","world");
        assertTrue(true);

    }
}
