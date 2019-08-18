package com.spring.zujian;

import org.springframework.beans.factory.annotation.Value;


public class TestEntity {

    @Value("${password}")
    private String password;

    public TestEntity() {
        System.out.println("我被创建了"+password);
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "password='" + password + '\'' +
                '}';
    }
}
