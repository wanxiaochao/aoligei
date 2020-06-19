package com.aoligei.dynamic_proxy_learn.jdk;

public class UserManagerImpl implements UserManager{

    @Override
    public void addUser(String name, String password) {
        System.out.println("调用了UserManagerImpl.addUser()方法");
    }

    @Override
    public void detUser(String name) {
        System.out.println("调用了UserManagerImpl.detUser()的方法");
    }
}
