package com.aoligei.springsecurity_jwt_redis.service;

import com.aoligei.springsecurity_jwt_redis.dao.UserDao;
import com.aoligei.springsecurity_jwt_redis.entity.User;
import com.aoligei.springsecurity_jwt_redis.utils.SUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(s);
        return new SUserDetails(user);
    }
}

