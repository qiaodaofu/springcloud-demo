package com.spring.interceptor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        TestMethodInterceptor testMethodInterceptor = (TestMethodInterceptor) configApplicationContext.getBean("testMethodInterceptor");
        LogTest logTest = (LogTest) configApplicationContext.getBean("logTest");

        Object instance = testMethodInterceptor.getInstance(logTest);
        logTest = (LogTest)instance;
        String alilaila = logTest.test1("alilaila");
        logTest.test2(1,1);
        System.out.println(alilaila);
    }
}
