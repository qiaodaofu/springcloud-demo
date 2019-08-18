package com.spring.config;

import com.spring.*;
import com.spring.aop.log.LogTest;
import com.spring.aop.TestAOP;
import com.spring.aware.TestWare;
import com.spring.bean.*;
import com.spring.value.TestValue;
import org.springframework.context.annotation.*;

import java.math.BigDecimal;

//@Import(value = {Dog.class, TestImport.class,TestImportBeanDefinitionRegistrar.class})
@EnableAspectJAutoProxy //启动切面
@Configuration
@PropertySource(value = "Test-Value.properties")
public class TestConfig {

    @Conditional(value = TestCondition.class)
    @Bean
    public UserEntity userEntityConfig(){
        System.out.println("我是windows下被加载的");
        return new UserEntity("你好","你好吗",bank());
    }

    @Bean
    public Bank bank(){
        Bank bank = new Bank();
        bank.setAccount(new BigDecimal(3030));
        bank.setPrice(new BigDecimal(3000000));
        return bank;
    }

    @Bean("testFactoryBean")
    public TestFactoryBean testFactoryBean(){
        return new TestFactoryBean();
    }


/*    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Cat cat(){
        return new Cat();
    }*/

//    @Bean
//    public HuoChe huoChe(){
//        return new HuoChe();
//    }

    @Bean
    public Qiche qiche(){
        return new Qiche();
    }

    @Bean("testWare")
    public TestWare testWare(){
        return new TestWare();
    }
    @Primary
    @Bean("testValue1")
    public TestValue testValue1(){
        return new TestValue();
    }
    @Bean("testValue")
    public TestValue testValue(){
        return new TestValue("qq",11,"qq",2);
    }

    @Bean
    public TestAOP testAOP(){
        return new TestAOP();
    }

    @Bean
    public LogTest logTest(){
        return new LogTest();
    }
}
