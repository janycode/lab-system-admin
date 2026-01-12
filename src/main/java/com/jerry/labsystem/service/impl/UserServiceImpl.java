package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.dao.UserMapper;
import com.jerry.labsystem.pojo.User;
import com.jerry.labsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService<User> {
    @Autowired
    private UserMapper<User> userMapper;

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public void updateUserList(User user) {
        userMapper.updateUserList(user);
    }

    @Override
    public void deleteUserList(Integer id) {
        userMapper.deleteUserList(id);
    }

    @Override
    public void addUserList(User user) {
        userMapper.addUserList(user);
    }
}
