package com.jdk8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class Test2 {

    public void printf(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
        myInterface.test2();
        MyInterface.test3();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.printf(() -> System.out.println("1.5"));

        LocalDateTime now = LocalDateTime.now();
        Instant now1 = Instant.now();
        System.out.println(now1.getEpochSecond());

        DateTimeFormatter isoDateTime = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String format = isoDateTime.format(now);
        System.out.println(format);

        Executors.newFixedThreadPool(1);

    }

}
