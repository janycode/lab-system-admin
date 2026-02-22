package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.dao.UserMapper;
import com.jerry.labsystem.pojo.User;
import com.jerry.labsystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务 impl
 *
 * @author Jerry(姜源)
 * @since 2026/02/22
 */
@Service
public class UserServiceImpl implements UserService<User> {
    @Resource
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
