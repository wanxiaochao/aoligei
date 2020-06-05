package com.alg.userapi.controller;

import com.alg.common.pojo.User;
import com.alg.userinterface.service.UserInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {

    @Reference
    private UserInterface userInterface;

    @GetMapping("/user/{id}")
    public User userDetails(@PathVariable("id") Integer id) {
        return userInterface.findById(id);
    }

    @RequestMapping("/findByUsername")
    public User findByUsername(@RequestParam("username") String username) {
        return userInterface.findByUsername(username);
    }

    /**
     * 获取授权的用户信息
     *
     * @param principal 当前用户
     * @return 授权信息
     */
    @GetMapping("/current/get")
    public Principal user(Principal principal) {
        return principal;
    }

}
