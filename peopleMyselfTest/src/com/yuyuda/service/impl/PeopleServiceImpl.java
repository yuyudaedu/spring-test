package com.yuyuda.service.impl;

import com.yuyuda.pojo.People;
import com.yuyuda.service.PeopleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PeopleServiceImpl implements PeopleService {
    @Override
    public List<People> show() throws IOException {
        //加载mapper配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //通过构造者设计模式获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取数据库操作对象session
        SqlSession session = factory.openSession();
        //selectList方法查询全部
        List<People> list = session.selectList("com.yuyuda.mapper.PeopleMapper.selectAll");
        session.close();
        return list;
    }
}
