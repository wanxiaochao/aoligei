package com.aoligei.dynamic_proxy_learn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//jdk动态代理类
public class JDKDynamicProxy implements InvocationHandler {

    //被代理目标对象
    private Object targetObject;

    public Object newProxy(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理前 ：逻辑处理的方法(函数)
        checkPopedom();
        Object reflect = null;
        reflect = method.invoke(targetObject, args);
        isOk();
        return reflect;
    }

    private void isOk() {
        System.out.println("权限通过：isOk");
    }

    private void checkPopedom() {
        System.out.println("检查权限：checkPopedom");
    }
}
