package com.yuyuda.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession对象
     * @return
     */
    public static SqlSession getSession() {
        SqlSession session = tl.get();
        if (session == null) {
            tl.set(factory.openSession());
        }
        return tl.get();
    }

    /**
     * 关闭SqlSession
     */
    public static void closeSession() {
        SqlSession session = tl.get();
        if (session != null) session.close();
        tl.set(null);
    }
}
