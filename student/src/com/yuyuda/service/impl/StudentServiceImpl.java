package com.yuyuda.service.impl;

import com.yuyuda.mapper.StudentMapper;
import com.yuyuda.mapper.TeacherMapper;
import com.yuyuda.pojo.PageInfo;
import com.yuyuda.pojo.Student;
import com.yuyuda.service.StudentService;
import com.yuyuda.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageStr) {
        int page = 1;
        int pageSize = 2;
        if (pageStr != null && !pageStr.equals("")) {
            page = Integer.parseInt(pageStr);
        }
        if (pageSizeStr != null && !pageSizeStr.equals("")) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setPageSize(pageSize);
        pageInfo.setStartPage(pageSize * (page -1));
        pageInfo.setSname(sname);
        pageInfo.setTname(tname);
        List<Student> studentList = studentMapper.selByPage(pageInfo);

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        for (Student student : studentList) {
            student.setTeacher(teacherMapper.selById(student.getTid()));
        }
        pageInfo.setList(studentList);
        long count = studentMapper.selCountByPageInfo(pageInfo);
        pageInfo.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);

        return pageInfo;
    }
}
