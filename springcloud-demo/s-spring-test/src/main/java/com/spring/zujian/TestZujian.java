package com.spring.zujian;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestZujian implements BeanFactoryPostProcessor, BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        Stream<String> stream = Arrays.stream(beanDefinitionNames);
        stream.forEach(str-> System.out.println(str));
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(s -> System.out.println(s+"=========================="));
        registry.registerBeanDefinition("zidingyi",new RootBeanDefinition(TestEntity.class));
    }
}
