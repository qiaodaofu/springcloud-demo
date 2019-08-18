package com.spring.thread;

import java.util.concurrent.Exchanger;

public class ExchangeTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        A a = new A(exchanger);
        B b = new B(exchanger);
        new Thread(a).start();
        new Thread(b).start();
    }

    static class A implements Runnable{

        Exchanger<String> exchanger;

        public A(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            String s = "A";
            try {
                System.out.println("A交换之前"+s);
                String exchange = exchanger.exchange(s);
                Thread.sleep(10000);
                System.out.println("A交换之后"+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class B implements Runnable{

        Exchanger<String> exchanger;

        public B(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            String s = "B";
            try {
                System.out.println("B交换之前"+s);
                String exchange = exchanger.exchange(s);
                System.out.println("B交换之后"+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
