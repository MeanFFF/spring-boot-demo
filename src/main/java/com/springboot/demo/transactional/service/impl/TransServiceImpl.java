package com.springboot.demo.transactional.service.impl;

import com.springboot.demo.transactional.mapper.UserMapper;
import com.springboot.demo.transactional.service.ITransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransServiceImpl implements ITransService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void hello() {
        userMapper.insert("hello", "gogogo", "liuliuliu");
//        int a = 1/0;
    }
}
