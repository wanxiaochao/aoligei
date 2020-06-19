package com.aoligei.dynamic_proxy_learn.demo;

public class StaticProxyTest {

    public static void main(String[] args) {
        Person zhangsan = new Student("张三");
        Person moneitor = new StudentsProxy(zhangsan);
        moneitor.giveMoney();
    }

}
