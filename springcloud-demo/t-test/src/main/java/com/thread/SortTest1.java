package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SortTest1 {

    int a= 10;
    boolean flag = false;


//线程1

    public void writer() {

        a= 1;
        flag= true;
    }

//线程2

    public void reader() {
        Lock lock = new ReentrantLock();
        lock.lock();
        if(flag){
            int i = a+1;
            System.out.println(i);
        }else{
            System.out.println(flag);
        }

    }



    public static void main(String[] args) {
        SortTest1 sortTest = new SortTest1();

        while (true){
            new Thread(() -> {
                sortTest.writer();
                sortTest.reader();

            }).start();
        }
    }
}
