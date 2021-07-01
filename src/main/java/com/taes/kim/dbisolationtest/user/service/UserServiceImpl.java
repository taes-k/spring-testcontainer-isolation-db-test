package com.taes.kim.dbisolationtest.user.service;

import com.taes.kim.dbisolationtest.user.entity.User;
import com.taes.kim.dbisolationtest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean isExistUser(String id)
    {
        return userRepository.existsById(id);
    }

    @Override
    public User setUser(User user)
    {
        return userRepository.save(user);
    }
}
