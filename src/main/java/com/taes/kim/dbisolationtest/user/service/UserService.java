package com.taes.kim.dbisolationtest.user.service;

import com.taes.kim.dbisolationtest.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    List<User> getAllUsers();

    Optional<User> getUser(String id);

    boolean isExistUser(String id);

    User setUser(User user);
}
