package com.taes.kim.dbisolationtest.user.controller;

import com.taes.kim.dbisolationtest.user.dto.UserDto;
import com.taes.kim.dbisolationtest.user.entity.User;
import com.taes.kim.dbisolationtest.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(
        UserService userService
        , ModelMapper modelMapper)
    {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<UserDto.Res> getAllUsers()
    {
        return userService.getAllUsers().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @PostMapping()
    public UserDto.Res setUser(@RequestBody UserDto.Req userDto)
    {
        if (userService.isExistUser(userDto.getId()))
            throw new IllegalArgumentException("중복되는 ID가 존재합니다.");

        User user = convertToEntity(userDto);
        user = userService.setUser(user);
        return convertToDto(user);
    }


    private User convertToEntity(UserDto.Req userDto)
    {
        return modelMapper.typeMap(UserDto.Req.class, User.class)
            .map(userDto);
    }

    private UserDto.Res convertToDto(User user)
    {
        return modelMapper.typeMap(User.class, UserDto.Res.class)
            .map(user);
    }

}
