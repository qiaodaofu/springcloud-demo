package com.spring.proxy;

public class Test {

    public static void main(String[] args) {

//        Fulei fulei = new Zilei();
        Testaaaaa fulei = () -> System.out.println("aaa");
        ProxyDong proxyDong = new ProxyDong();
        fulei = proxyDong.proxyInstanceFulei(fulei);
//        fulei.aa();
//        TestMethodInterceptor testMethodInterceptor = new TestMethodInterceptor();
//        fulei = (Fulei) testMethodInterceptor.getInstance(fulei);
        fulei.aa();
    }
}
