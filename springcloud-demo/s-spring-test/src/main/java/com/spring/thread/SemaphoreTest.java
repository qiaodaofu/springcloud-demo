package com.spring.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3,true);
        String[] strings = {"aa","bb","cc","dd","ee","ff","gg","aa","bb","cc","dd","ee","ff","gg","aa","bb","cc","dd","ee","ff","gg","aa","bb","cc","dd","ee","ff","gg"};

        for (int i = 0; i < strings.length; i++) {
            Test test = new Test(semaphore,strings[i]);
            Thread thread = new Thread(test);
            thread.start();
        }
    }

    public static class Test implements  Runnable{

        private Semaphore semaphore;
        private String str;

        public Test(Semaphore semaphore, String str) {
            this.semaphore = semaphore;
            this.str = str;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("执行之前"+semaphore.availablePermits());
                Thread.sleep(10000);
                System.out.println("执行操作"+str);
                System.out.println("执行之后"+semaphore.availablePermits());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
