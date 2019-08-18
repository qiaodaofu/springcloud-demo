package com.spring.thread;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class VolatileTest {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (int i = -(stack.size()-1); i < stack.size(); i++) {
            System.out.println(stack.pop());
        }
    }

    public <T> T get(List<T> x){

        return x.get(0);
    }


}