package com.xpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.xpl.dao")
@EnableTransactionManagement
@EnableEurekaClient
@SpringBootApplication
public class BusiProviderConfigApp {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(BusiProviderConfigApp.class, args);
    }

}
