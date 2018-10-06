package com.rpc.service;

import com.rpc.entity.UserInfo;

/**
 * @description
 * @create by shadow
 * @date 2018/7/6
 * @since 1.0
 */
public interface UserService {

    UserInfo getUserById(Integer id);

    Integer addUser(UserInfo userInfo);
}
