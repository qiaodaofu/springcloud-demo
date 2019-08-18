package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class S_X_test {

    private static AtomicInteger integer = new AtomicInteger(0);


    private static class Add implements Runnable {
        @Override
        public void run() {
            System.out.println(integer.incrementAndGet());
        }
    }
    private static class Get implements Runnable {
        @Override
        public void run() {
            System.out.println(integer.getAndDecrement());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Add());
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(new Add());
        thread2.start();
        thread2.join();

    }
}
