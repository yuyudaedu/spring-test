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
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        //用构造者设计模式实例化得到SqlSession工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //所有增删改查都在这个对象上
        SqlSession session = factory.openSession();

        List<People> list = session.selectList("com.yuyuda.mapper.PeopleMapper.selAll");
        session.close();
        return list;
    }
}
