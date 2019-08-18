package com.thread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fork_Join {

    private static int size  = 40000000;


    /**
     * @return 生产数组
     */
    public static int[] makerArray(){
        int[] ints = new int[size];
        Random random = new Random(100);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(size);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = Fork_Join.makerArray();
//      ---------------没有使用ForkJoin的执行时间------------
        /*int count =0;
        long a = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            count=ints[i]+count;
        }
        long b = System.currentTimeMillis();
        System.out.println("执行时间"+(b-a)+"总和："+count);*/
//      ---------------没有使用ForkJoin的执行时间为20毫秒------------

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTest forkJoinTest = new ForkJoinTest(ints,0,ints.length-1);
        long start = System.currentTimeMillis();
        forkJoinPool.invoke(forkJoinTest);
        System.out.println("执行任务中..............");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static class ForkJoinTest extends RecursiveTask<Integer>{

//        阈值
        private int size = Fork_Join.size/2;
//      要进行拆分的数组
        private int[] src;
//        开始下标
        private int fromIndex;
//        结束下标
        private int toIndex;

        public ForkJoinTest(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            if(toIndex-fromIndex < size){
                int count =0;
                for (int i = fromIndex; i < toIndex; i++) {
                    count=src[i]+count;
                }
                return count;
            }else {
                /* 递归拆分，如果是数组大小为10000，阈值为1000，第一次拆分后的大小，mid为5000right为5000，没有达到阈值，就会再次拆分
                *   一直达到阈值后才会停止拆分
                * */
                int mid = (fromIndex+toIndex)/2; //第一次拆分，再次进入就是第二次拆分了
                ForkJoinTest leftFork = new ForkJoinTest(src,fromIndex,mid);
                ForkJoinTest rightFork = new ForkJoinTest(src,mid+1,toIndex);
                invokeAll(leftFork,rightFork);
                return leftFork.join()+rightFork.join();
            }
        }

    }
}
