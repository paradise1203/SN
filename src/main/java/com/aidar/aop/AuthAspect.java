package com.aidar.aop;

import com.aidar.service.AuthService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paradise on 23.03.16.
 */
@Component
@Aspect
public class AuthAspect {

    @Autowired
    private AuthService authService;

    @Around("@annotation(RequireAnonymous)")
    public Object requireAnonymous(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        if (!authService.hasAuthority(request)) {
            return jp.proceed();
        }
        response.sendRedirect("redirect:/user/main");
        return null;
    }

    @Around("execution(* com.aidar.controller.UserController.getMainPage(..))")
    public Object requireAuth(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        if (authService.hasAuthority(request)) {
            return jp.proceed();
        }
        response.sendRedirect("/login");
        return null;
    }

}
