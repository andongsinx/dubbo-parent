package com.dubbo.consumer.controller;

import com.rpc.entity.UserInfo;
import com.rpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description
 * @create by shadow
 * @date 2018/7/5
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;


    @RequestMapping("/{id}")
    public UserInfo getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }


}

