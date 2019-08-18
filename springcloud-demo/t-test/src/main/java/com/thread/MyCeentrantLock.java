package com.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个不是可重入锁，可能出现死锁
 */
public class MyCeentrantLock implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer{

        /**
         *      获取锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
//            compareAndSetState 这个是一个原子操作，判断这把锁如果为0那么就给他设为1，这样就获取到了锁。
            if (compareAndSetState(0,arg)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }else{
                return false;
            }
        }

        /**
         * 释放锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (arg == getState()){
                throw new RuntimeException("没有可释放的锁");
            }
            setExclusiveOwnerThread(null);
            setState(arg);
            return true;
        }


        /**
         * @return 是否占用锁
         */
        @Override
        protected boolean isHeldExclusively() {
            return 1 == getState();
        }

        Condition condition = new ConditionObject();
    }

    private static Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sync.tryRelease(0);
    }

    @Override
    public Condition newCondition() {
        return sync.condition;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Test()).start();
        }
    }

    private static AtomicInteger integer = new AtomicInteger(0);

    private static class Test implements Runnable{

        @Override
        public void run() {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            test1();
        }
    }
    private static Lock lock = new ReentrantLock();
    private static void test() throws InterruptedException {
        if (lock.tryLock(1000,TimeUnit.SECONDS)){
            try {
                Thread.sleep(2000);
                System.out.println(integer.getAndAdd(1));
            }finally {
                lock.unlock();
            }
        }
    }
    private static void test1(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(integer.getAndAdd(1));
        }finally {
            lock.unlock();
        }
    }

}
