package com.yuyuda.service;

import com.yuyuda.pojo.PageInfo;

public interface StudentService {
    /**
     *
     * @param sname
     * @param tname
     * @param pageSize
     * @param page
     * @return
     */
    PageInfo showPage(String sname, String tname, String pageSize, String page);
}
