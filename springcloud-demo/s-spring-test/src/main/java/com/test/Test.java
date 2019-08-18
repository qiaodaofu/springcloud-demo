package com.test;

import com.spring.TestAnnotation;
import com.spring.aop.log.LogTest;
import com.spring.config.TestConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


@ComponentScan(value = "com.spring.scan",excludeFilters = {
        @ComponentScan.Filter(type =FilterType.ANNOTATION,value = TestAnnotation.class)
},useDefaultFilters = true)
@Component
public class Test {

    public static void main(String[] args) {
//        加载配置文件
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Test.xml");
//        UserEntity userEntity = (UserEntity) context.getBean("userEntity");
//        System.out.println(userEntity.toString());
//        通过注解加载
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
//        UserEntity userEntity1 = (UserEntity)configApplicationContext.getBean("userEntityConfig");
//        Tiger tiger = (Tiger) configApplicationContext.getBean("testFactoryBean");
//        System.out.println(tiger);
//        System.out.println(userEntity1.toString());
//        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
//        Stream<String> stream = Arrays.stream(beanDefinitionNames);
//        stream.forEach(s -> System.out.println(s));


        LogTest logTest = configApplicationContext.getBean(LogTest.class);
        String test = logTest.test1("你好啊");
        System.out.println(test);
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Test.class);
//        String[] beanDefinitionNames1 = applicationContext.getBeanDefinitionNames();
//        for (String str :
//                beanDefinitionNames1) {
//            System.out.println(str);
//        }

//        Test12 test12 = (Test12) applicationContext.getBean("test12");
//        test12.test();

    }
}
