package com.yuyuda.mapper;

import com.yuyuda.pojo.UsersFans;
import java.util.List;

public interface UsersFansMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated
     */
    int insert(UsersFans record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated
     */
    UsersFans selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated
     */
    List<UsersFans> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UsersFans record);
}