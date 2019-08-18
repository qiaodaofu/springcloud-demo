package com.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HuoChe implements InitializingBean, DisposableBean {

    public HuoChe() {
        System.out.println("火车创建成功");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化bean.........");
    }
}
