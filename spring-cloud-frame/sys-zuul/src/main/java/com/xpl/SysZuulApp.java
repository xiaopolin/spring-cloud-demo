package com.xpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableZuulProxy
public class SysZuulApp {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(SysZuulApp.class, args);
    }

}
