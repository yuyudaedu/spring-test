package com.yuyuda.service.impl;

import com.yuyuda.mapper.MenuMapper;
import com.yuyuda.pojo.Menu;
import com.yuyuda.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> show() {
        return menuMapper.selByPid(0);
    }
}
