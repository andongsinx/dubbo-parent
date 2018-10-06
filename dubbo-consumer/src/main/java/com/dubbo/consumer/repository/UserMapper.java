package com.dubbo.consumer.repository;

import com.dubbo.consumer.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @create by shadow
 * @date 2018/7/5
 * @since 1.0
 */
@Repository
public interface UserMapper {

    @Select("select id ,username,age,phone from user_info where id=#{id}")
    UserInfo selectUserById(@Param("id") Integer id);
}
