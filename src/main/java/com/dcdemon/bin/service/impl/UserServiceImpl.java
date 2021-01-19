package com.dcdemon.bin.service.impl;

import com.dcdemon.bin.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void insert() {
        System.out.println("insert");
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
