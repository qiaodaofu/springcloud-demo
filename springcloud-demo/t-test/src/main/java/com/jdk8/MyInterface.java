package com.jdk8;

@FunctionalInterface
public interface MyInterface {

    void test();

    default void test2(){
        System.out.println(3);
    }

    static void test3(){
        System.out.println(4);
    }

}
