package com.yuyuda.service;

import com.yuyuda.pojo.PageInfo;

import java.io.IOException;

public interface PeopleService {
    /**
     * 分页显示
     * @param pageSize
     * @param page
     * @return
     */
    PageInfo showPage(int pageSize, int page) throws IOException;
}
