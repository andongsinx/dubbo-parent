package com.dubbo.provider.service.impl;

import com.dubbo.provider.repository.UserMapper;
import com.rpc.entity.UserInfo;
import com.rpc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description
 * @create by shadow
 * @date 2018/7/4
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserInfo getUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    @Transactional
    public Integer addUser(UserInfo userInfo) {
        try {
            userMapper.insertUserInfo(userInfo);
            //int a = 1/0;
        } catch (Exception e) {
            throw new RuntimeException("测试事务");
        }
        return 1;
    }
}
