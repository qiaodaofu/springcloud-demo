package com.spring.aop;

import com.spring.aop.log.LogTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

        LogTest logTest = configApplicationContext.getBean(LogTest.class);
//        logTest.test2(1,1);
        String test = logTest.test1("你好啊");
        System.out.println(test);
    }
}
