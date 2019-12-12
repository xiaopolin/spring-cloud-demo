package com.xpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigServer
public class SysConfigApp {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(SysConfigApp.class, args);
    }

}
