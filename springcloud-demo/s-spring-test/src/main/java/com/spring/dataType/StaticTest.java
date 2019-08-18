package com.spring.dataType;

public class StaticTest {
    static int i = 0;

    int j = 0;

    public static void main(String[] args) {
      /*  int i = StaticTest.i=1;
        System.out.println(i);
        StaticTest test1 = new StaticTest();
        int ji = test1.i=2;
        int j1 = test1.j=3;
        System.out.println("test1=="+ji);
        System.out.println("test1=="+j1);

        StaticTest test2 = new StaticTest();
        int j2 = test2.j;
        System.out.println("test2=="+test1.i);
        System.out.println("test2=="+j2);*/

      Integer integer1 = new Integer(40);
      Integer integer2 = new Integer(40);
      Integer integer3 = new Integer(0);
      Integer integer4 = 40;

        System.out.println(integer1 == integer2);
        System.out.println(integer1==(integer2+integer3));
        System.out.println(integer4==integer1);

    }

}
