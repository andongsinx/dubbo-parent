package com.dubbo.consumer.entity;

import java.io.Serializable;

/**
 * @description
 * @create by shadow
 * @date 2018/7/5
 * @since 1.0
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = -6662011604707547923L;

    private Integer id;

    private String username;

    private String phone;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserInfo() {
    }

    public UserInfo(Integer id, String username, String phone, Integer age) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
