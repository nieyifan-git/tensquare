package com.tensquare.gathering;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;


/**
 * @author nieyifan
 * @createTime 2019/11/25 14:40
 */
@SpringBootApplication
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

}
