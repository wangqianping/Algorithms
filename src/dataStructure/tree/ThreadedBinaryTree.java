package dataStructure.tree;

/**
 * 线索化二叉树
 */
public class ThreadedBinaryTree {

    private ThreadedNode root;
    ThreadedNode preNode;//用于临时存储前驱节点

    public ThreadedNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    public void frontShow() {
        if (root != null) {
            root.frontShow();
        }
    }

    public void midShow() {
        root.minShow();
    }

    public void afterShow() {
        root.afterShow();
    }

    public ThreadedNode frontSearch(int val) {
        return root.frontSearch(val);
    }

    public ThreadedNode midSearch(int val) {
        return root.midSearch(val);
    }

    public ThreadedNode afterSearch(int val) {
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

    public void threadedNodes(){
        threadedNodes(root);
    }

    //中序线索化二叉树
    public void threadedNodes(ThreadedNode threadedNode) {

        if (threadedNode != null) {

            //处理左子树
            threadedNodes(threadedNode.getLeftNode());

            if (threadedNode.getLeftNode() == null) {
                threadedNode.setLeftNode(preNode);
                threadedNode.setLeftType(1);
            }
            //处理前驱节点的右指针
            if (preNode != null && preNode.getRightNode() == null) {
                preNode.setRightNode(threadedNode);
                preNode.setRightType(1);
            }
            //当前节点作为下一个节点的前驱节点
            preNode = threadedNode;
            //处理右子树
            threadedNodes(threadedNode.getRightNode());
        }


    }

    //遍历线索二叉树
    public void threadIterate(){

        ThreadedNode node = root;

        while (node!=null){

            //先找到最开始的节点，最开始的节点的前驱节点为null
            while(node.leftType==0){
                node = node.getLeftNode();
            }
            System.out.println(node.getValue());
            //因为线索二叉树每一个节点都已经知道了前后节点，要先找出它的后继节点
            while(node.rightType==1){
                node = node.getRightNode();
                System.out.println(node.getValue());
            }
            //后继节点找完后再找右节点
            node = node.getRightNode();

        }


    }

    public static void main(String[] args) {
        ThreadedNode root = new ThreadedNode(1);
        ThreadedNode leftNode = new ThreadedNode(2);
        ThreadedNode rightNode = new ThreadedNode(3);
        leftNode.setLeftNode(new ThreadedNode(4));
        leftNode.setRightNode(new ThreadedNode(5));
        rightNode.setLeftNode(new ThreadedNode(6));
        rightNode.setRightNode(new ThreadedNode(7));
        root.setLeftNode(leftNode);
        root.setRightNode(rightNode);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        //中序遍历
        threadedBinaryTree.midShow();
//        ThreadedNode threadedNode5 = threadedBinaryTree.midSearch(5);
        //中序线索化二叉树
        threadedBinaryTree.threadedNodes();
        //验证
        System.out.println("========");
//        System.out.println(threadedNode5.getLeftNode().getValue());
//        System.out.println(threadedNode5.getRightNode().getValue());
//        System.out.println("========");
        threadedBinaryTree.threadIterate();
    }
}
