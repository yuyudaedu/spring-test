package com.yuyuda.service.impl;

import com.yuyuda.mapper.UserMapper;
import com.yuyuda.pojo.User;
import com.yuyuda.service.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.selByUserPwd(user);
    }
}
