package com.dcdemon.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 日志切面类
 */
@Aspect
@Component
public class MyLogAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.dcdemon..ITestService.*(..))")
    public void log4() {

    }

    /**
     * 切入点
     */
    @Pointcut("execution(* com.dcdemon..*.*(..))")
    public void logAll() {

    }

    /**
     * 前置额外
     */
    @Before("logAll()")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println(new Date() + " : @Before Log... : " + joinPoint.getTarget() + " # " + joinPoint.getSignature().getName());
    }

    /**
     * 后置额外
     */
    @AfterReturning(value = "logAll()", returning = "ret")
    public void afterLog(JoinPoint joinPoint, Object ret) {
        System.out.println(new Date() + " : @AfterReturning Log... : " + joinPoint.getTarget() + " # " + joinPoint.getSignature().getName());
        System.out.println(ret);
    }

    /**
     * 环绕额外
     */
    @Around("logAll()")
    public Object roundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(new Date() + " : @Around Log... : " + joinPoint.getTarget() + " # " + joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        System.out.println(new Date() + " : @Around Log... : " + joinPoint.getTarget() + " # " + joinPoint.getSignature().getName());
        return proceed;
    }

    @AfterThrowing(value = "logAll()", throwing = "e")
    public void throwsLog(Exception e) {
        System.out.println("@throwsLog : " + e.getMessage());
    }


}
