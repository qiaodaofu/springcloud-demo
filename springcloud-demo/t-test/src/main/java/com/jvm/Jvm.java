package com.jvm;

public class Jvm {

    private static class User{

        int i = 0;
        String str = "aa";
    }

    public static void test(){
        User user = new User();
        user.i = 9;
        user.str = "zxxczvxcv";
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            test();
        }
        long ll = System.currentTimeMillis();
        System.out.println((ll-l)+"ms");
    }
}
