package com.yuyuda.mapper;

import com.yuyuda.pojo.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> selByPid(int pid);
}
