package com.yuyuda.service.impl;

import com.yuyuda.mapper.UserMapper;
import com.yuyuda.pojo.User;
import com.yuyuda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "findAll")
    public List<User> findAll() {
        System.out.println("没有打印，则走缓存");
        List<User> list = userMapper.findAll();
        return list;
    }
}
