package com.yuyuda.service;

import com.yuyuda.pojo.Airplane;

import java.util.List;

public interface AirplaneService {
    List<Airplane> show(int takeid, int landid);

}
