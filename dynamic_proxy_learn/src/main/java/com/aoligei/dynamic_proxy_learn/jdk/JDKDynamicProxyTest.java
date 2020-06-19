package com.aoligei.dynamic_proxy_learn.jdk;

public class JDKDynamicProxyTest {

    public static void main(String[] args) {
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        UserManager userManager = (UserManager) jdkDynamicProxy.newProxy(new UserManagerImpl());
        userManager.addUser("tom","root");
        userManager.addUser("jack","root");

    }

}
