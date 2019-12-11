package com.xpl.framework.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonIRoleConfig {

    @Bean
    public IRule myIRole(){
        return new RoundRobinRule();
    }
}
