package com.yuyuda.test;


import com.yuyuda.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is) ;
        SqlSession session = factory.openSession();

        //selectList返回结果是一个list,适用于遍历
        /*List<Flower> list = session.selectList("com.yuyuda.mapper.FlowerMapper.selAll");
        for (Flower flower : list) {
            System.out.println(flower.toString());
        }*/

        //selectOne 返回结果是一个对象，适用于返回结果是一个变量或者一行数据时
        /*int count = session.selectOne("com.yuyuda.mapper.FlowerMapper.selById");
        System.out.println(count); */

        //selectMap 返回结果是一个map,mapKey把数据库中某个字段的值当作map的key
        //适用于通过某列取到这行数据的值
        //Map<Object, Object> map = session.selectMap("c", "name");
        //Map<Object, Flower> map = session.selectMap("c", "name");
        Map<Object, Map<Object, Object>> map = session.selectMap("c", "name");
        System.out.println(map);

        session.close();
    }
}
