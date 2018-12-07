package com.yuyuda.lzx.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yuyuda.lzx.dubbo.ServerApi;
import org.springframework.stereotype.Component;

@Service(interfaceClass = com.yuyuda.lzx.dubbo.ServerApi.class)
@Component
public class ServerApiImpl implements ServerApi {
    @Override
    public String demo(String msg) {
        return "spring-boot-" + msg;
    }
}
