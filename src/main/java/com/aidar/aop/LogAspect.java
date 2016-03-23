package com.aidar.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * Created by paradise on 23.03.16.
 */
@Component
@Aspect
public class LogAspect {

    private StringBuilder getMethodInfo(JoinPoint jp) {
        StringBuilder method = new StringBuilder();
        method.append(jp.getTarget().getClass().getSimpleName()).append(".")
                .append(jp.getSignature().getName()).append("() ")
                .append("was invoked at ").append(LocalTime.now());
        return method;
    }

    @Before("execution(* com.aidar.controller.*.*(..))")
    public void logWebRequest(JoinPoint jp) {
        System.out.println(getMethodInfo(jp));
    }

    @Around("execution(* com.aidar.repository.*.*(..))")
    public Object logDatabaseRequest(ProceedingJoinPoint jp) throws Throwable {
        StringBuilder info = getMethodInfo(jp);
        Object res = jp.proceed();
        info.append(" and finished at ").append(LocalTime.now());
        System.out.println(info);
        return res;
    }

}
