package com.spring.aop;

import com.spring.aop.log.LogTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy=true) //启动切面
@Configuration
public class TestConfig {


    @Bean
    public TestAOP testAOP(){
        return new TestAOP();
    }

    @Bean
    public LogTest logTest(){
        return new LogTest();
    }
}
