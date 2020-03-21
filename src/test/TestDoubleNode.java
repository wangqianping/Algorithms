package test;

import dataStructure.DoubleNode;

public class TestDoubleNode {

    public static void main(String[] args) {

        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);

        doubleNode1.insert(doubleNode2);
        doubleNode1.insert(doubleNode3);

        System.out.println(doubleNode1.previous().getData());//2
        System.out.println(doubleNode1.next().getData());//3
        System.out.println(doubleNode1.next().previous().getData());//1
        System.out.println(doubleNode1.next().next().getData());//2
        System.out.println(doubleNode1.next().next().previous().getData());//3
        System.out.println(doubleNode1.next().next().next().getData());//1

    }
}
