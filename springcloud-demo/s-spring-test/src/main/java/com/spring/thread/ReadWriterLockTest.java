package com.spring.thread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriterLockTest {


    static class Read implements Runnable{

        private ReadWriteLock readWriteLock;
        private AtomicInteger integer;

        public Read(ReadWriteLock readWriteLock, AtomicInteger integer) {
            this.readWriteLock = readWriteLock;
            this.integer = integer;
        }

        @Override
        public void run() {
            readWriteLock.readLock().lock();
            try {
                Thread.sleep(new Random().nextInt(100));
                System.out.println(integer.getAndAdd(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readWriteLock.readLock().unlock();
            }
        }
    }


    static class Write implements Runnable{

        private ReadWriteLock readWriteLock;
        private int integer;

        public Write(ReadWriteLock readWriteLock, int integer) {
            this.readWriteLock = readWriteLock;
            this.integer = integer;
        }

        @Override
        public void run() {
            readWriteLock.writeLock().lock();
            try {
                System.out.println(integer++);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }


    static class Sync implements Runnable{

        private int integer;

        public Sync(int integer) {
            this.integer = integer;
        }

        @Override
        public void run() {
            test();
        }

        public void test(){
            synchronized (this){
                System.out.println(integer++);
            }
        }
    }


    public static void main(String[] args) {

//        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//        Read read = new Read(readWriteLock,new AtomicInteger(0));
//        Write write = new Write(readWriteLock,0);
        Sync sync = new Sync(0);
        for (int i = 0; i < 500000; i++) {
//            new Thread(read).start();
//            new Thread(write).start();
            new Thread(sync).start();
        }
    }

}
