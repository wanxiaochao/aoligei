package com.aoligei.dynamic_proxy_learn.cglib;

public class CglibDynamicProxyTest {

    public static void main(String[] args) {
        HelloService helloService = (HelloService)new MyMethodInterceptor().setClass(HelloService.class);
        helloService.sayHello();
        helloService.sayOthers("无法代理final方法");

    }

}
