package com.dcdemon.bin.service.impl;

import com.dcdemon.bin.dao.TestDao;
import com.dcdemon.bin.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestDao testDao;

    @Override
    public void print() {
        testDao.daoPrint();
        int i = 0;
        int a = 10 / i;
    }
}
