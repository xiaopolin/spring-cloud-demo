package com.xpl.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class SimpleAOP {

    @Pointcut("execution(* com.xpl.web.controller.*.*(..))")
    public void controllerPointcut(){}

    @Before("controllerPointcut()")
    public void beforeMethod(JoinPoint joinPoint){
        log.info("接口被调用并将其记录: " + getMethodInfo(joinPoint));
    }

    private String getMethodName(JoinPoint joinPoint)
    {
        return joinPoint.getSignature().getName();
    }

    private String getClassName(JoinPoint joinPoint)
    {
        return joinPoint.getSignature().getDeclaringType().getSimpleName();
    }

    private String getMethodInfo(JoinPoint joinPoint)
    {
        String className = getClassName(joinPoint);
        String methodName = getMethodName(joinPoint);
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        StringBuilder sb = null;
        if (parameterNames.length > 0)
        {
            sb = new StringBuilder();
            for (int i = 0; i < parameterNames.length; i++)
            {
                String value = joinPoint.getArgs()[i] != null ? joinPoint.getArgs()[i].toString() : "null";
                sb.append(parameterNames[i] + ":" + value + " , ");
            }
        }
        sb = sb == null ? new StringBuilder() : sb;
        String info = String.format("CLASS -> %s | METHOD -> %s | ARGS -> %s", className, methodName, sb.toString());
        return info;
    }
}
