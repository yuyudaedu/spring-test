package com.yuyuda.controller;

import com.yuyuda.pojo.Users;
import com.yuyuda.pojo.vo.UsersVO;
import com.yuyuda.service.UserService;
import com.yuyuda.utils.MD5Utils;
import com.yuyuda.utils.yuyudaJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(value = "用户注册、登录接口", tags = "用户注册、登录接口")
@Slf4j
@RestController
@RequestMapping("/user/")
public class RegistLoginController extends BaseController{

    @Autowired
    private UserService userService;

    private UsersVO setUserSessionToken(Users users) {
        String uniqueToken = UUID.randomUUID().toString();
        redis.set(USER_REDIS_SESSION + ":" + users.getId(), uniqueToken, 1000*60*30);
        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(users, usersVO);
        usersVO.setUserToken(uniqueToken);
        return usersVO;
    }

    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public yuyudaJSONResult regist(@RequestBody Users users) throws Exception {
        if (StringUtils.isBlank(users.getUsername()) || StringUtils.isBlank(users.getPassword())) {
            return yuyudaJSONResult.errorMsg("用户名和密码不能为空！");
        }

        boolean userNameIsExist = userService.userNameIsExist(users.getUsername());

        if (userNameIsExist) {
            return yuyudaJSONResult.errorMsg("用户名已经存在，请换一个重试");
        } else {
            users.setNickname(users.getUsername());
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            users.setFansCounts(0);
            users.setFollowCounts(0);
            users.setReceiveLikeCounts(0);
            userService.saveUser(users);
        }
        users.setPassword("");
        UsersVO usersVO = this.setUserSessionToken(users);
        return yuyudaJSONResult.ok(usersVO);
    }

    @ApiOperation(value = "用户登录接口", tags = "用户登录接口")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public yuyudaJSONResult login(@RequestBody Users users) {
        if (StringUtils.isBlank(users.getUsername()) || StringUtils.isBlank(users.getPassword())) {
            return yuyudaJSONResult.errorMsg("用户名或密码不能为空");
        }

        //判断用户是否存在
        Users result = null;
        try {
            result = userService.queryUserByUsernamePassword(users.getUsername(), MD5Utils.getMD5Str(users.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            log.info("MD5加密异常 {}", e);
        }

        if (result == null) {
            return yuyudaJSONResult.errorMsg("用户名或密码错误");
        } else {
            users.setPassword("");
            UsersVO usersVO = this.setUserSessionToken(result);
            return yuyudaJSONResult.ok(usersVO);
        }
    }

    @ApiOperation(value = "用户注销接口", tags = "用户注销接口")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public yuyudaJSONResult logout(String userId) {
        redis.del(USER_REDIS_SESSION + ":" + userId);
        return yuyudaJSONResult.ok();
    }
}
