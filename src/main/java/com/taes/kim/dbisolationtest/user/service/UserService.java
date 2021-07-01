package com.taes.kim.dbisolationtest.user.service;

import com.taes.kim.dbisolationtest.user.entity.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();

    boolean isExistUser(String id);

    User setUser(User user);
}
