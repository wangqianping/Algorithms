package test;

import dataStructure.Stack;

public class TestStack {

    public static void main(String[] args){

        Stack demo = new Stack();

        demo.push(1);
        demo.push(2);
        demo.push(3);

        System.out.println(demo.peek());

        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.pop());

    }
}
