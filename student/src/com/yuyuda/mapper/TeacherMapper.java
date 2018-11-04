package com.yuyuda.mapper;

import com.yuyuda.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    /**
     * 根据tid查询老师
     * @param tid
     * @return
     */
    Teacher selById(int tid);
}
