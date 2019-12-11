package com.xpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.xpl.dao")
@EnableTransactionManagement
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class BusiProviderHystrixApp {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(BusiProviderHystrixApp.class, args);
    }

}
