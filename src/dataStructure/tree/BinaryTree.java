package dataStructure.tree;

/**
 * 链式存储的二叉树
 */
public class BinaryTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        binaryTree.setRoot(root);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        root.setLeftNode(leftNode);
        root.setRightNode(rightNode);
        leftNode.setLeftNode(new TreeNode(4));
        leftNode.setRightNode(new TreeNode(5));
        rightNode.setLeftNode(new TreeNode(6));
        rightNode.setRightNode(new TreeNode(7));
        //遍历
        //前序遍历
        binaryTree.frontShow();
        System.out.println("=========");
        //中序遍历
        binaryTree.midShow();
        System.out.println("=========");
        //后续遍历
        binaryTree.afterShow();
        //查找
        TreeNode result = binaryTree.frontSearch(1);
        result = binaryTree.midSearch(2);
        result = binaryTree.afterSearch(2);
        System.out.println(result == leftNode);
        //删除
        binaryTree.delete(2);
        binaryTree.frontShow();
    }

    public void frontShow() {
        if(root!=null){
            root.frontShow();
        }
    }

    public void midShow() {
        root.minShow();
    }

    public void afterShow() {
        root.afterShow();
    }

    public TreeNode frontSearch(int val) {
        return root.frontSearch(val);
    }

    public TreeNode midSearch(int val) {
        return root.midSearch(val);
    }

    public TreeNode afterSearch(int val) {
        if (root != null) {
            return root.afterSearch(val);
        }
        return null;
    }

    public void delete(int val) {

        if (root != null) {
            root.delete(val);
        }
    }
}
