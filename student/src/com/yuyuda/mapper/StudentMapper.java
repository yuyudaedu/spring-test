package com.yuyuda.mapper;

import com.yuyuda.pojo.PageInfo;
import com.yuyuda.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 分页显示学生老师信息
     * @param pageInfo
     * @return
     */
    List<Student> selByPage(PageInfo pageInfo);

    /**
     * 学生总数
     * @param pageInfo
     * @return
     */
    long selCountByPageInfo(PageInfo pageInfo);
}
