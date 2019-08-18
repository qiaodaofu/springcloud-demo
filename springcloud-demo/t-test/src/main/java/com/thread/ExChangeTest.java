package com.thread;

import java.util.concurrent.Exchanger;

public class ExChangeTest {

  static  Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                String aa = exchanger.exchange("aa");
                System.out.println(aa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                String bb = exchanger.exchange("bb");
//                System.out.println(bb);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
