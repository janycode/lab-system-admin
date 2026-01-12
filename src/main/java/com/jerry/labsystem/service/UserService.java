package com.jerry.labsystem.service;

import java.util.List;

public interface UserService<User> {
    List<User> getUserList(User user);
    void updateUserList(User user);
    void deleteUserList(Integer id);
    void addUserList(User user);
}
