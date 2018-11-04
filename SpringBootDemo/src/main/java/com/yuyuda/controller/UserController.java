package com.yuyuda.controller;

import com.yuyuda.pojo.User;
import com.yuyuda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/pojo")
    public User showUser() {
        User user = new User();
        user.setId(1);
        user.setName("刘志弦");
        user.setPassword("1234556");
        return user;
    }

    @RequestMapping("/map")
    public Map<String, Object> showMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "张学友");
        map.put("address", "香港");
        return map;
    }

    @RequestMapping("/list")
    public List<User> showList() {
        List<User> list = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setName("张学友");
        user1.setPassword("zxy");

        list.add(user1);
        User user2 = new User();
        user2.setId(2);
        user2.setName("刘德华");
        user2.setPassword("ldh");

        list.add(user2);
        return list;
    }

    @RequestMapping("/ssm")
    public String showUserList(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("list", list);
        return  "show";
    }
}
