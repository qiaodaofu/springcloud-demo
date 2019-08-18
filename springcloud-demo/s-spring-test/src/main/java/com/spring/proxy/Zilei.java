package com.spring.proxy;

import org.springframework.transaction.annotation.Transactional;

public class Zilei implements Fulei{
    @Override
    public void aa() {
        System.out.println("aa被执行了");
    }

    @Transactional
    @Override
    public String str() {
        return "你好";
    }
}
