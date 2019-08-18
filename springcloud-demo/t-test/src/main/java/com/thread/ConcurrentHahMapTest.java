package com.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHahMapTest {

   static  ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        map.put("aa","1");
        System.out.println(map.putIfAbsent("aa","2"));

    }
}
