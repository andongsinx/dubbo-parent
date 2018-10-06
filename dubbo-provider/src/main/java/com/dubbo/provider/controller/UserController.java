package com.dubbo.provider.controller;

import com.rpc.entity.UserInfo;
import com.rpc.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description 用户控制器
 * @create by shadow
 * @date 2018/7/4
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @RequestMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable(value = "id") Integer id) {

        UserInfo userInfo = userService.getUserById(id);
        return userInfo;
    }
    @RequestMapping("/add")
    public String insertUserInfo(UserInfo userInfo) {
        Integer integer = userService.addUser(userInfo);

        return "success";
    }


}
