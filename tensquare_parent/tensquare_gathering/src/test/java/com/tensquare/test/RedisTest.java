package com.tensquare.test;

import com.tensquare.gathering.GatheringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author nieyifan
 * @createTime 2019/11/25 15:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={GatheringApplication.class})
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01(){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test1","hello");
    }
}
