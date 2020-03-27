package dataStructure.tree;

/**
 * 顺序存的二叉树
 */
public class ArrayBinaryTree {

    private int[] data;

    public ArrayBinaryTree(int[] val) {
        this.data = val;
    }

    public void frontShow() {
        frontShow(0);
    }

    /**
     * 前序遍历
     *
     * @param start 遍历的起始位置
     */
    public void frontShow(int start) {

        if (data == null || data.length <= 0) {
            return;
        }

        System.out.println(data[start]);

        if ((2 * start + 1) < data.length) {
            frontShow(2 * start + 1);
        }

        if ((2 * start + 2) < data.length) {
            frontShow(2 * start + 2);
        }

    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(data);
        arrayBinaryTree.frontShow();
    }


}
