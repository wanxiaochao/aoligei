package com.aoligei.dynamic_proxy_learn.demo;

public class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {

        System.out.println(name + "交保护费50");
    }
}
