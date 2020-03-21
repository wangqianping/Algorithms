package test;

import dataStructure.Queue;

import java.util.Arrays;

public class TestQueue {

    public static void main(String[] args){

        Queue queue = new Queue();

        queue.add(1);
        queue.add(2);
        queue.add(3);


        System.out.println(queue.poll());
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());

    }
}
