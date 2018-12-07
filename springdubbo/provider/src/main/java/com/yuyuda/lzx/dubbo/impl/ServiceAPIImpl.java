package com.yuyuda.lzx.dubbo.impl;

import com.yuyuda.lzx.dubbo.ServiceAPI;

public class ServiceAPIImpl implements ServiceAPI {
    @Override
    public String demo(String msg) {
        System.out.println(msg);
        return "demo-msg-" + msg;
    }
}
