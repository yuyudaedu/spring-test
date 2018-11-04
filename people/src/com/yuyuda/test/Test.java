package com.yuyuda.test;

import com.yuyuda.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class Test {

    private SqlSession session;
    private String mapper = "com.yuyuda.mapper.PeopleMapper";

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
    }

    @After
    public void end() {
        session.close();
    }

    @org.junit.Test
    public void selAll() {
        List<Object> list = session.selectList(mapper +  ".selAll");
        System.out.println(list);
    }

    @org.junit.Test
    public void oneParameter() {
        Object selectOne = session.selectOne(mapper + ".oneParameter", 1);
        System.out.println(selectOne);
    }

    @org.junit.Test
    public void oneParameter2() {
        Object selectOne = session.selectOne(mapper + ".oneParameter2", 1);
        System.out.println(selectOne);
    }

    @org.junit.Test
    public void entityObject() {
        People people = new People();
        people.setId(1);
        Object selectOne = session.selectOne(mapper + ".entityObject", people);
        System.out.println(selectOne);
    }

    @org.junit.Test
    public void entityObject2() {
        People people = new People();
        people.setId(1);
        Object selectOne = session.selectOne(mapper + ".entityObject2", people);
        System.out.println(selectOne);
    }

    @org.junit.Test
    public void mapWay() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "刘德华");
        Object selectOne = session.selectOne(mapper + ".mapWay", map);
        System.out.println(selectOne);
    }

    @org.junit.Test
    public void page() {
        int pageSize = 1;
        int page = 2;
        HashMap<String, Object> map = new HashMap<>();

        map.put("pageSize", pageSize);
        map.put("pageStart", pageSize * (page - 1));

        List<People> list = session.selectList(mapper + ".page", map);
        System.out.println(list);
    }

    @org.junit.Test
    public void insert1() {
        People people = new People();
        people.setName("刘志弦");
        people.setAge(30);

        int i = session.insert(mapper + ".insert1", people);
        if (i > 0) {
            session.commit();
            System.out.println("插入成功！");
        } else {
            session.rollback();
            System.out.println("插入失败！");
        }
    }
}
