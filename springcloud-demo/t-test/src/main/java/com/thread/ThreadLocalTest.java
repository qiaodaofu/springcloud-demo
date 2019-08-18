package com.thread;

import java.util.LinkedList;

public class ThreadLocalTest {

    static ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 1);

    LinkedList<String> linkedList = new LinkedList<>();

    public static class TestThread extends  Thread{
        int i;
        public TestThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            Integer integer = local.get();
            System.out.println("开始： " + integer);
            integer = integer+i;
            local.set(integer);
            System.out.println(local.get());
        }
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 30; i++) {
            new TestThread(i).start();
        }*/
        ThreadLocalTest test = new ThreadLocalTest();

        test.waitTest();
    }

    public void values(){
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
    }

    public synchronized void waitTest() {
        values();
        System.out.println(linkedList.removeFirst());
    }
}
