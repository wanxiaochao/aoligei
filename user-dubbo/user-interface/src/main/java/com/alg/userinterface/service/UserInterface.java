package com.alg.userinterface.service;

import com.alg.common.pojo.User;

public interface UserInterface {

    User findById(Integer id);

    User findByUsername(String username);
}
