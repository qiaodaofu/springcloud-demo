package com.thread;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        Thread threadMain = Thread.currentThread();
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(new Test(threadMain));
            thread.start();
            threadMain = thread;
        }
//        threadMain.sleep(2000);
        System.out.println(Thread.currentThread().getName());
    }

    public static class Test implements Runnable{

        Thread thread;

        public Test(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我被执行了，执行我的线程是："+thread.getName());
        }
    }

}
