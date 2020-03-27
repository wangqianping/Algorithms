package dataStructure.tree;

public class TreeNode {

    private TreeNode leftNode;
    private int value;
    private TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //前序遍历
    public void frontShow() {
        System.out.println(value);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    //中序遍历
    public void minShow() {
        if (leftNode != null) {
            leftNode.minShow();
        }
        System.out.println(value);
        if (rightNode != null) {
            rightNode.minShow();
        }
    }

    //后序遍历
    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }

        System.out.println(value);
    }

    //前序查找
    public TreeNode frontSearch(int value) {
        TreeNode target = null;
        if (this.value == value) {
            return this;
        } else {
            if (leftNode != null) {
                target = leftNode.frontSearch(value);
            }
            if (target != null) {
                return target;
            }
            if (rightNode != null) {
                target = rightNode.frontSearch(value);
            }
        }
        return target;
    }

    //中序查找
    public TreeNode midSearch(int value) {
        TreeNode target = null;

        if (leftNode != null) {
            target = leftNode.midSearch(value);
        }
        if (target != null) {
            return target;
        }

        if (this.value == value) {
            return this;
        }

        if (rightNode != null) {
            target = rightNode.midSearch(value);
        }

        return target;
    }

    //后序查找
    public TreeNode afterSearch(int value) {
        TreeNode target = null;

        if (leftNode != null) {
            target = leftNode.afterSearch(value);
        }

        if (target != null) {
            return target;
        }

        if (rightNode != null) {
            target = rightNode.afterSearch(value);
        }

        if (target != null) {
            return target;
        }

        if (this.value == value) {
            return this;
        }

        return target;
    }

    //删除一个子树
    public void delete(int value){

        TreeNode parent = this;

        if(parent.leftNode!=null && parent.leftNode.value==value){
            parent.leftNode = null;
            return;
        }

        if(parent.rightNode!=null && parent.rightNode.value==value){
            parent.rightNode = null;
            return;
        }

        parent = this.leftNode;
        if(parent!=null){
            parent.delete(value);
        }

        parent = this.rightNode;
        if(parent!=null){
            parent.delete(value);
        }
    }

}
