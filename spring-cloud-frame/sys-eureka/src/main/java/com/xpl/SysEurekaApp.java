package com.xpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class SysEurekaApp {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(SysEurekaApp.class, args);
    }

}
