package test;

import dataStructure.LoopNode;

public class TestLoopNode {

    public static void main(String[] args) {

        LoopNode loopNode1 = new LoopNode(1);
        LoopNode loopNode2 = new LoopNode(2);
        LoopNode loopNode3 = new LoopNode(3);

        loopNode1.insert(loopNode2);
        loopNode2.insert(loopNode3);

        System.out.println(loopNode1.next().getData());
        System.out.println(loopNode2.next().getData());
        System.out.println(loopNode3.next().getData());

    }
}
