package com.yuyuda.mapper;

import com.yuyuda.pojo.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleMapper {
    List<People> selAll();

    List<People> selMultiCondition(int id, String name);

    //List<People> selMultiCondition(@Param("id") int id, @Param("name") String name);

    List<People> selDynamicSql(@Param("id") int id, @Param("name") String name);

    List<People> selDynamicSqlChoose(@Param("id") int id, @Param("name") String name);
}
