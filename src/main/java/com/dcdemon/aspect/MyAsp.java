package com.dcdemon.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyAsp {
    public MyAsp() {
        System.out.println("MyAsp Create");
    }

//    @Pointcut("execution(* com.dcdemon.bin.service.impl.TestServiceImpl.print())")
//    public void pointCut() {
//    }
//
//    @Before("pointCut()")
//    public void beforeLog(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        System.out.println("MyAsp before:" + name);
//    }

}
