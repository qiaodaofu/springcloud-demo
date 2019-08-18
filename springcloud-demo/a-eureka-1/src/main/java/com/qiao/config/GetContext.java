package com.qiao.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;

public class GetContext implements ApplicationContextAware {


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(beanDefinitionNames.length);
        Arrays.stream(beanDefinitionNames).forEach(s -> System.out.println(s+"====================="));
    }

}
