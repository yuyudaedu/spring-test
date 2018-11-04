package com.yuyuda.service.impl;

import com.yuyuda.mapper.UserMapper;
import com.yuyuda.pojo.User;
import com.yuyuda.service.UserService;
import org.springframework.beans.factory.annotation.Value;

public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}")
    private String driver;
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        System.out.println(driver);
        return userMapper.selUserByNamePwd(user);
    }
}
