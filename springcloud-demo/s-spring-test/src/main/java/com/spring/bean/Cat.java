package com.spring.bean;

public class Cat {

    private String name;

    public Cat() {
        System.out.println("我被创建了，Cat");
    }

    public void init(){
        this.name  = "乔灿";
        System.out.println("我被初始化了，Cat"+this.name);
    }
    public void destroy(){
        System.out.println("我被销毁了，Cat");
    }

}
