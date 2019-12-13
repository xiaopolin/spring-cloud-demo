编辑于2019/12/13

# 本项目是SpringClud的Demo

不是框架，不是框架，不是框架！！！



## 使用SpringBoot版本2.1.6.RELEASE

## 使用SpringCloud版本Greenwich.SR3



## 项目结构

### busi-api

~~~properties
大部分项目中业务部分需要的实体类PO和错误码Constant
~~~

### busi-provider

~~~properties
最基础的服务提供者，使用Mybaties连接操作数据库
其余整个Cloud各模块的进阶版服务提供者都在此项目上改动
~~~



### sys-eureka

~~~properties
eureka服务端及服务监控中心
~~~

### sys-zuul

~~~properties
zuul网关服务端
~~~

### sys-hystrix

~~~properties
hystrix-dashboard监控中心
~~~

### sys-ribbon

~~~properties
使用ribbon在restTemplate的基础上作为消费者调用服务（提供负载均衡）
~~~

### sys-feign

~~~properties
使用feign作为消费者调用服务（同时提供负载均衡）
~~~

### sys-config

~~~properties
config云配置服务端
~~~



### busi-provider-hystrix

~~~properties
使用hystrix在服务生产者中提供服务熔断
~~~

### busi-feign-hystrix

~~~properties
使用hystrix在feign作为消费者中提供服务降级
~~~



### busi-provider-config

~~~properties
使用config为服务生产者提供云配置
~~~

### busi-feign-config

~~~properties
使用config为feign作为的服务消费者提供云配置
~~~





## 尚未解决的问题

1. 引入eureka后logback-spring.xml无法获取spring.application.name

   ~~~properties
   ERROR in ch.qos.logback.classic.joran.action.ContextNameAction - Failed to rename context [APP_NAME_IS_UNDEFINED] as [busi-provider] java.lang.IllegalStateException: Context has been already given a name
   ~~~

2. zuul配置服务只能在yml中配置，有空将其配置在config.java

   ~~~yml
   zuul:
     routes:
       provider:
         serviceId: busi-provider
         path: /provider/**
   ~~~