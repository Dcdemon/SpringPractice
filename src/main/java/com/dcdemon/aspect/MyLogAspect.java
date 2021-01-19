package com.dcdemon.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 日志切面类
 */
@Aspect
@Component
public class MyLogAspect {

    public MyLogAspect() {
        System.out.println("MyLogAspect Create");
    }

    /**
     * 切入点
     */
    @Pointcut("execution(* com.dcdemon..ITestService.*(..))")
    public void log4() {

    }

    /**
     * 额外功能
     */
    @Before("log4()")
    public void beforeLog(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("MyLogAspect before:" + name);
    }

}
