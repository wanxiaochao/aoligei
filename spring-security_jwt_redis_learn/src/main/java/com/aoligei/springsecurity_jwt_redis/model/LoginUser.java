package com.aoligei.springsecurity_jwt_redis.model;

import lombok.Data;

@Data
public class LoginUser {
    private String username;
    private String password;
    private Integer rememberMe;
}
