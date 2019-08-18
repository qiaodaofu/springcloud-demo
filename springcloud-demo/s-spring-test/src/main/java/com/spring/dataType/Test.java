package com.spring.dataType;

import java.util.Random;

public class Test {

   static int a = 0;
    static boolean flag = false;

   public static void init(){
       a = 1;
       flag = true;
   }
   public static void use(){
       if(flag){
            int i = a*a;
       }else{
           System.out.println("没有进来");
       }
   }

   static class A implements  Runnable{
       @Override
       public void run() {
           init();
           Random random = new Random();
           int i = random.nextInt(100);
           try {
               Thread.sleep(i);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           use();
       }
   }

    public static void main(String[] args) {

        for (int i = 0; i < 100000; i++) {
            new Thread(new A()).start();
            new Thread(new A()).start();
        }
    }
}
