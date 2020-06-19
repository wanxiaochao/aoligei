package com.aoligei.dynamic_proxy_learn.demo;

public class StudentsProxy implements Person {
    //被代理的学生
    Student stu;

    public StudentsProxy(Person stu) {
        //只代理学生对象
        if (stu.getClass() == Student.class) {
            this.stu = (Student) stu;
        }
    }

    @Override
    public void giveMoney() {
        stu.giveMoney();
    }
}
