package test;

import dataStructure.Node;

public class TestNode {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.append(new Node(2)).append(new Node(3)).append(new Node(4));

        System.out.println(node.next().next().getData());
        System.out.println(node.next().next().next().hasNext());

        node.removeNext();
        node.show();
        node.removeNext();
        node.show();

        node.insert(new Node(5));
        node.show();

    }
}
