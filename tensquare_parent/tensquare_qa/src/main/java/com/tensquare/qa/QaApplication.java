package com.tensquare.qa;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author nieyifan
 * @createTime 2019/11/25 10:08
 */
@SpringBootApplication
public class QaApplication {
    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
