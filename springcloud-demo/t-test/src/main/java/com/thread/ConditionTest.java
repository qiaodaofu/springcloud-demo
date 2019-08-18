package com.thread;

import java.util.concurrent.locks.*;

/**
 *  提供了和Sync下wait、notify、notifyAll一样的功能
 */
public class ConditionTest {

    private static Lock lock = new ReentrantLock();
    private static Condition await = lock.newCondition();
    private static Condition signal = lock.newCondition();

    static void await(){
        lock.lock();
        try {
            System.out.println("初始化");
            await.await();
            System.out.println("被唤醒了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    static void signal(){
        lock.lock();
        try {
            System.out.println("等待2秒钟唤醒");
            Thread.sleep(2000);
            System.out.println("唤醒操作");
            signal.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private static class AwaitTest implements Runnable{
        @Override
        public void run() {
            await();
        }
    }
    private static class SignalTest implements Runnable{
        @Override
        public void run() {
            signal();
        }
    }

    public static void main(String[] args) {
        new Thread(new AwaitTest()).start();
        new Thread(new SignalTest()).start();
    }
}
