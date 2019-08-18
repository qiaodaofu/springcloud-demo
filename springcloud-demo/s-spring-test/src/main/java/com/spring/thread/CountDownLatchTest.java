package com.spring.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(50000);
        ThreadTest threadTest = new ThreadTest(countDownLatch);
        for (int i = 0; i < 50000; i++) {
            Thread thread = new Thread(threadTest);
            thread.start();
        }
        countDownLatch.await();
        System.out.println("end");

    }

    public static class ThreadTest implements Runnable{
        private CountDownLatch countDownLatch;

        public ThreadTest(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("执行前。。。");
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行之后。。。");
        }
    }

}
