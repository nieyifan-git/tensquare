package com.tensquare.search;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName RecuritApplication
 * @Description TODO
 * @Author 45775
 * @Date 2019/12/25 23:01
 * @Version 1.0
 */
@SpringBootApplication
public class RecuritApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecuritApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
