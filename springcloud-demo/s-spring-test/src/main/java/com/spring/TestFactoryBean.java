package com.spring;

import com.spring.bean.Tiger;
import org.springframework.beans.factory.FactoryBean;

public class TestFactoryBean implements FactoryBean<Tiger> {
    @Override
    public Tiger getObject() throws Exception {
        
        return new Tiger();
    }

    @Override
    public Class<?> getObjectType() {
        return Tiger.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
