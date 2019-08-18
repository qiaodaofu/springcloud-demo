package com.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class TestWare implements ApplicationContextAware, BeanNameAware , EmbeddedValueResolverAware {

    private  ApplicationContext applicationContext;
    private String name;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("${password}");
        System.out.println(s+"=================================================================================");
    }
}
