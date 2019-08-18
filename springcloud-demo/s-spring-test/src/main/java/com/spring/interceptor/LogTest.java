package com.spring.interceptor;

public class LogTest {

    public String test1(String str){
        return str;
    }

    public int test2(int x,int y){
        System.out.println("test2");
        return x/y;
    }
}
