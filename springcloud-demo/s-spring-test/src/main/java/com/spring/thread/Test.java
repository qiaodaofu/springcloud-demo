package com.spring.thread;

public class Test  {



    public static void main(String[] args) {

        int ii = 0;
        a a = new a(ii);
        for (int i = 0; i < 10000; i++) {
            new Thread(a).start();
        }

    }


    static class a implements Runnable{

        private int i;

        public a(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            test(this.i);
        }

        public void test(Integer integer){
            synchronized (integer){
                System.out.println(integer++);
            }
        }
    }

}
