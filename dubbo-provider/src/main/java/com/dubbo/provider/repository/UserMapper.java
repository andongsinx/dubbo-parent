package com.dubbo.provider.repository;

import com.rpc.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @create by shadow
 * @date 2018/7/4
 * @since 1.0
 */
@Repository
public interface UserMapper {



    UserInfo selectUserById(@Param("id") Integer id);

    @Insert("insert into user_info(username,age,phone) values(#{user.username},#{user.age},#{user.phone})")
    Integer insertUserInfo(@Param("user") UserInfo userInfo);

}
