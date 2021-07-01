package com.taes.kim.dbisolationtest.user.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto
{
    private UserDto()
    {
        throw new IllegalStateException("outer class");
    }

    @Getter
    @Setter
    public static class Req
    {
        private String id;

        private String password;

        private String name;
    }

    @Getter
    @Setter
    public static class Res
    {
        private String id;

        private String name;
    }
}
