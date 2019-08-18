package com.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

   private static CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

    private static class Test implements Runnable{
        @Override
        public void run() {
            System.out.println("初始化"+Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("执行了"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            new Thread(new Test()).start();
        }
    }
}
