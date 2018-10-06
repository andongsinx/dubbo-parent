package com.dubbo.consumer.service.impl;


import com.dubbo.consumer.entity.UserInfo;
import com.dubbo.consumer.service.UserServiceConsumer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description
 * @create by shadow
 * @date 2018/7/6
 * @since 1.0
 */
@Service
public class UserServiceConsumerImpl implements UserServiceConsumer {

    @Override
    public UserInfo getUserById(Integer id) {
        return null;
    }
}
