package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.dao.MoocUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Service(interfaceClass = UserAPI.class, loadbalance = "roundrobin")
public class UserServiceImpl implements UserAPI {

    @Resource
    MoocUserTMapper moocUserTMapper;

    @Override
    public boolean register(UserModel userModel) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(userModel.getUsername());
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        moocUserT.setUserPwd(md5Password);
        moocUserT.setEmail(userModel.getEmail());
        moocUserT.setAddress(userModel.getAddress());
        moocUserT.setUserPhone(userModel.getPhone());
        Integer insert = moocUserTMapper.insert(moocUserT);

        return (insert > 0) ? true : false;
    }

    @Override
    public int login(String username, String password) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(username);

        MoocUserT userT = moocUserTMapper.selectOne(moocUserT);
        if (userT != null && userT.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (userT.getUserPwd().equals(md5Password)) {
                return userT.getUuid();
            }
        }
        return 0;
    }

    @Override
    public boolean checkUsername(String username) {
        EntityWrapper<MoocUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", username);

        Integer count = moocUserTMapper.selectCount(entityWrapper);
        if (count != null && count > 0) {
            return false;
        } else {
            return true;
        }
    }

    private UserInfoModel userModel2UserInfoModel(MoocUserT moocUserT) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setUsername(moocUserT.getUserName());
        userInfoModel.setSex(moocUserT.getUserSex());
        userInfoModel.setPhone(moocUserT.getUserPhone());
        userInfoModel.setNickname(moocUserT.getNickName());
        userInfoModel.setLifeState(""+moocUserT.getLifeState());
        userInfoModel.setHeadAddress(moocUserT.getHeadUrl());
        userInfoModel.setEmail(moocUserT.getEmail());
        userInfoModel.setBirthday(moocUserT.getBirthday());
        userInfoModel.setBiography(moocUserT.getBiography());
        userInfoModel.setBeginTime(moocUserT.getBeginTime().getTime());
        userInfoModel.setAddress(moocUserT.getAddress());
        userInfoModel.setUuid(moocUserT.getUuid());
        userInfoModel.setUpdateTime(moocUserT.getUpdateTime().getTime());
        return userInfoModel;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        MoocUserT moocUserT = moocUserTMapper.selectById(uuid);
        UserInfoModel userInfoModel = userModel2UserInfoModel(moocUserT);
        return userInfoModel;
    }

    private Date time2Date(long time) {
        Date date = new Date(time);
        return date;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUuid(userInfoModel.getUuid());
        moocUserT.setUserSex(userInfoModel.getSex());
        moocUserT.setUpdateTime(time2Date(System.currentTimeMillis()));
        moocUserT.setNickName(userInfoModel.getNickname());
        moocUserT.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        moocUserT.setHeadUrl(userInfoModel.getHeadAddress());
        moocUserT.setBirthday(userInfoModel.getBirthday());
        moocUserT.setBiography(userInfoModel.getBiography());
        moocUserT.setEmail(userInfoModel.getEmail());
        moocUserT.setAddress(userInfoModel.getAddress());
        moocUserT.setUserPhone(userInfoModel.getPhone());
        Integer res = moocUserTMapper.updateById(moocUserT);
        if (res > 0) {
            UserInfoModel userInfo = getUserInfo(moocUserT.getUuid());
            return userInfo;
        } else {
            return userInfoModel;
        }
    }
}
