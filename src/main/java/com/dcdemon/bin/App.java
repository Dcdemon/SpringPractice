package com.dcdemon.bin;

import com.dcdemon.bin.service.UserService;
import com.dcdemon.bin.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 */
public class App {

    @Autowired
    private UserService userService;

    public Object getProxy1(Object service) {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                method.invoke(service, args);
                System.out.println("after");
                return null;
            }
        };
        Object proxy = Proxy.newProxyInstance(App.class.getClassLoader(), service.getClass().getInterfaces(), invocationHandler);
        return proxy;
    }

    public UserService getProxy2(UserService userService) {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            System.out.println("before");
            method.invoke(userService, args);
            System.out.println("after");
            return null;
        };
        UserService proxy = (UserService) Proxy.newProxyInstance(App.class.getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        return proxy;
    }

    @Test
    public void testProxy() {
        userService = new UserServiceImpl();
        userService = (UserService) getProxy1(userService);
        userService.insert();
        userService.update();
    }

    public static void main(String[] args) {

    }
}
