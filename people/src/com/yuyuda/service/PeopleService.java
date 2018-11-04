package com.yuyuda.service;

import com.yuyuda.pojo.People;

import java.io.IOException;
import java.util.List;

public interface PeopleService {

    /**
     * 显示全部
     * @return
     */
    List<People> show() throws IOException;
}
