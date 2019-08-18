package com.spring.aop.log;

import org.springframework.aop.framework.AopContext;

public class LogTest {

    public String test1(String str){
        LogTest service = AopContext.currentProxy() != null ? (LogTest)AopContext.currentProxy() : this;
        service.test2(10,10);
        return str;
    }

    public int test2(int x,int y){
        return x/y;
    }
}
