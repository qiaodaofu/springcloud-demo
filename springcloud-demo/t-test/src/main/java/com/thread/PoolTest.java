package com.thread;

public class PoolTest {

    private Integer i =new Integer(1);
    private Integer ii =new Integer(1);

    public  void aa(){
        synchronized (i){
            synchronized (ii){
                System.out.println("你好");
            }
        }
    }

    public  void bb(){
        synchronized (i){
            synchronized (ii){
                System.out.println("你好");
            }
        }
    }


    public static void main(String[] args) {
        PoolTest poolTest = new PoolTest();
        for (int i = 0; i < 10000 ; i++) {
            new Thread(() -> {
                poolTest.aa();
                poolTest.bb();
            }).start();
        }
    }
}
