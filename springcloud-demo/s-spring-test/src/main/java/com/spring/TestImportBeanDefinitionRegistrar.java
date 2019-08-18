package com.spring;

import com.spring.bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean b = registry.containsBeanDefinition("com.spring.bean.Cat");
//        判断容器是否有Cat这个类实例，有的话就添加Pig实例到容器中
        if (b){
            registry.registerBeanDefinition("pig",new RootBeanDefinition(Pig.class));
        }
    }
}
