package com.thread;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tests {


        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            for(int i=0;i<5;i++) {
                executorService.execute(new MyTask(i));
            }
            Executors.newCachedThreadPool();
            CompletionService completionService = new ExecutorCompletionService(executorService);
            System.out.println(executorService.isShutdown());

            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("executorService="+executorService);
            List<Runnable> runnables = executorService.shutdownNow();
            System.out.println("executorService="+runnables);
            System.out.println(executorService.isShutdown());
        }

        static class MyTask implements Runnable{
            private Integer num;
            MyTask(Integer num){
                this.num = num;
            }

            public void run() {
                    System.out.println(Thread.currentThread().getName()+" 在度假中...");
            }

        }

}
