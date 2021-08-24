package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    //获取所有用户
    List<User> list();
    //根据id获取单个用户
    User getById(Integer id);
    //增加用户
    void addUser(User user);
    //更新用户信息
    void updateUser(User user);
    //根据id删除用户
    int deleteUser(Integer id);

}
