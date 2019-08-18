package com.spring.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,new Test1());
        Test test = new Test(cyclicBarrier);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(test);
            thread.start();
        }
    }

    public static class Test implements  Runnable{

        private CyclicBarrier cyclicBarrier;

        public Test(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行前");
                this.cyclicBarrier.await();
                System.out.println("执行后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Test1 implements  Runnable{




        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
