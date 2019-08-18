package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDong implements InvocationHandler {

    private Testaaaaa fulei;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("之前");
        Object invoke = method.invoke(fulei, args);
        System.out.println("之后");
        return invoke;
    }

    public Testaaaaa proxyInstanceFulei(Testaaaaa fulei){
        this.fulei = fulei;
        return (Testaaaaa)Proxy.newProxyInstance(fulei.getClass().getClassLoader(),fulei.getClass().getInterfaces(),this);
    }
}
