package test;

import huffmanTree.HuffmanTree;
import huffmanTree.Node;

public class TestHuffmanTree {

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,8,29,5,11,23,14};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node node = huffmanTree.creatHuffmanTree(arr);
        System.out.println(node);
    }
}
