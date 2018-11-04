package com.yuyuda.mapper;

import com.yuyuda.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM `user` WHERE `name`=#{name} AND `password`=#{password}")
    User selByUserPwd(User user);
}
