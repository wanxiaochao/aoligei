package com.alg.userapi.controller;

import com.alg.common.pojo.User;
import com.alg.userinterface.service.UserInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    private UserInterface userInterface;

    @GetMapping("/user/{id}")
    public User userDetails(@PathVariable("id") Integer id) {
        return userInterface.findById(id);
    }

}
