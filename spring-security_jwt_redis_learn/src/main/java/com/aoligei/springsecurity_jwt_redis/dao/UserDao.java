package com.aoligei.springsecurity_jwt_redis.dao;

import com.aoligei.springsecurity_jwt_redis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

}
