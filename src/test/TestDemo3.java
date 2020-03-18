package test;

import dataStructure.Demo3;

public class TestDemo3 {

    public static void main(String[] args){

        Demo3 demo = new Demo3();

        demo.push(1);
        demo.push(2);
        demo.push(3);

        System.out.println(demo.peek());

        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.pop());

    }
}
