package com.bin;

import static org.junit.Assert.assertTrue;

import com.dcdemon.bin.service.ITestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    public void testAutowired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ITestService bean = context.getBean(ITestService.class);
        bean.print();

    }
}
