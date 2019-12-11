package com.xpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableHystrixDashboard
public class SysHystrix {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(SysHystrix.class, args);
    }

}
