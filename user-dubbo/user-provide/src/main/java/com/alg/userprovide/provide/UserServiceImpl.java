package com.alg.userprovide.provide;

import com.alg.common.pojo.User;
import com.alg.userinterface.service.UserInterface;
import com.alg.userprovide.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserInterface {

    @Resource
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }
}
