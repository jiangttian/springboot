package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> list();
    User getById(Integer id);
    void addUser(User user);
    void updateUser(User user);
    int deleteUser(Integer id);
}
