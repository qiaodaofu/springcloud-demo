package com.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static CountDownLatch latch = new CountDownLatch(100);

    private static class Test implements Runnable{
        private int i;

        public Test(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("初始化");
            latch.countDown(); //执行完上面代码后，然后执行这个方法，阈值就会减一
            System.out.println("阈值到达了：线程为 "+Thread.currentThread()+" i： "+i);
        }
    }

    private static class WaitTest implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("阈值到达了，我被执行了");
        }
    }

    public static void main(String[] args)  {
//        只有阈值为0了才会执行WaitTest await下面的代码
        new Thread(new WaitTest()).start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Test(i)).start();

        }


    }

}
