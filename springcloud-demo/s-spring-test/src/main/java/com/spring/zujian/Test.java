package com.spring.zujian;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        TestEntity testEntity = (TestEntity)applicationContext.getBean("testEntity");
        System.out.println(testEntity.toString());
    }

}
