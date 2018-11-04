package com.yuyuda.test;

import com.yuyuda.mapper.PeopleMapper;
import com.yuyuda.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Test {

    /*public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        PeopleMapper peopleMapper = session.getMapper(PeopleMapper.class);
        //List<People> list = peopleMapper.selAll();
        List<People> list = peopleMapper.selMultiCondition(1, "刘德华");
        for (People people: list) {
            System.out.println(people);
        }
        session.close();
    }*/

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入ID：");
        String idStr = scanner.nextLine();
        System.out.println(idStr);
        int id = 0;
        if (idStr != null && !idStr.equals("")) {
            id = Integer.parseInt(idStr);
        }

        System.out.println("请输入姓名：");
        String name = scanner.nextLine();

        PeopleMapper peopleMapper = session.getMapper(PeopleMapper.class);
        //List<People> list = peopleMapper.selDynamicSql(id, name);
        List<People> list = peopleMapper.selDynamicSqlChoose(id, name);
        for (People people : list) {
            System.out.println(people);
        }
        session.close();
    }
}
