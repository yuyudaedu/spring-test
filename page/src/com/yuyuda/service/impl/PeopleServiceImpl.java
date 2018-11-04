package com.yuyuda.service.impl;

import com.yuyuda.pojo.PageInfo;
import com.yuyuda.service.PeopleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class PeopleServiceImpl implements PeopleService {
    /**
     * 分页显示
     * @param pageSize
     * @param page
     * @return
     */
    @Override
    public PageInfo showPage(int pageSize, int page) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        HashMap<String, Object> map = new HashMap<>();
        map.put("pageStart", pageSize * (page - 1));
        map.put("pageSize", pageSize);

        List<Object> list = session.selectList("com.yuyuda.mapper.PeopleMapper.selByPage", map);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(pageSize);
        pageInfo.setPage(page);
        pageInfo.setList(list);

        long count = session.selectOne("com.yuyuda.mapper.PeopleMapper.selCount");

        pageInfo.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
        return pageInfo;
    }
}
