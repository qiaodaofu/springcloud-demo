package com.spring.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableAspectJAutoProxy
public class TestConfig {

    @Bean
    public LogTest logTest(){
        return new LogTest();
    }

    @Bean
    public TestMethodInterceptor testMethodInterceptor(){
        return new TestMethodInterceptor();
    }
}
