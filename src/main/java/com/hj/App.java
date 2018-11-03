package com.hj;

import com.hj.u.handler.RedisTemplateHandler;
import com.hj.u.handler.RedisTemplateHandlerTmp;
import com.hj.u.handler.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger= LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
        RedisTemplateHandler redisTemplateHandler=(RedisTemplateHandler)context.getBean("redisTemplateHandler");
        redisTemplateHandler.testRedisTemplate();
        RedisTemplateHandlerTmp redisTemplateHandlerTmp=(RedisTemplateHandlerTmp)context.getBean("redisTemplateHandlerTmp");
        redisTemplateHandlerTmp.testRedisTemplate();

    }
}
