package com.jdk8;

public interface JDK8_New {

    default String getString(){
        return "你获取到了我";
    }
    static String getStaticString(){
        return "你获取到了静态的我";
    }
}
