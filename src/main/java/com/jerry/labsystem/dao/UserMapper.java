package com.jerry.labsystem.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper<User> {
    List<User> getUserList(User user);
    void updateUserList(User user);
    void deleteUserList(Integer id);
    void addUserList(User user);
}
