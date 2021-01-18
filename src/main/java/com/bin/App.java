package com.bin;

import com.bin.service.UserService;
import com.bin.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 */
public class App {

    @Autowired
    private UserService userService;

    public UserService getProxy(UserService userService) {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("logging");
                method.invoke(userService, args);
                return null;
            }
        };
        UserService proxy = (UserService) Proxy.newProxyInstance(App.class.getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        return proxy;
    }

    @Test
    public void testProxy() {
        userService = new UserServiceImpl();
        userService.insert();
        userService.update();
        userService = getProxy(userService);
        userService.insert();
        userService.update();
        userService = getProxy(userService);
        userService.insert();
        userService.update();
    }

    public static void main(String[] args) {

    }
}
