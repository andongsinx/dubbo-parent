package com.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.consumer.entity.UserInfo;

/**
 * @description
 * @create by shadow
 * @date 2018/7/5
 * @since 1.0
 */
public interface UserServiceConsumer {

    UserInfo getUserById(Integer id);

}
