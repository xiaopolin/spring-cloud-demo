package com.xpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class SysRibbonApp {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(SysRibbonApp.class, args);
    }

}
