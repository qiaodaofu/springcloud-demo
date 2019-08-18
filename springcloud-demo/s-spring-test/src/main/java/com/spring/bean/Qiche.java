package com.spring.bean;

import com.spring.value.TestValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public class Qiche implements BeanPostProcessor, InitializingBean, DisposableBean {

//    @Qualifier("testValue1")
    @Autowired
    private TestValue testValue;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization................."+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean.getClass().getName()=="com.spring.bean.Bank"){
            Annotation[] annotations = bean.getClass().getAnnotations();
            Stream<Annotation> stream = Arrays.stream(annotations);
            System.out.println("======================================================");
            stream.forEach(annotation -> System.out.println(annotation));
            System.out.println("======================================================");

            bean = new Bank(new BigDecimal(10000),new BigDecimal(10000000));
        }
        System.out.println("postProcessAfterInitialization................."+bean);
        return bean;
    }

    @Override
    public void destroy() throws Exception {


        System.out.println("销毁beanQiche");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化beanQiche.........");
        System.out.println("加载的bean是：============="+testValue.toString());
    }
}
