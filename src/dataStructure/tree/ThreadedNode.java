package dataStructure.tree;

/**
 * 线索化二叉树的节点，增加了节点类型
 */
public class ThreadedNode {

    private ThreadedNode leftNode;
    private int value;
    private ThreadedNode rightNode;
    //标识左节点和y右节点类型,0表示左右节点，1表示前后节点
    int leftType;
    int rightType;


    public ThreadedNode(int value) {
        this.value = value;
    }

    public ThreadedNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ThreadedNode leftNode) {
        this.leftNode = leftNode;
    }

    public ThreadedNode getRightNode() {
        return rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public void setRightNode(ThreadedNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
    public ThreadedNode frontSearch(int value) {
        ThreadedNode target = null;
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
    public ThreadedNode midSearch(int value) {
        ThreadedNode target = null;

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
    public ThreadedNode afterSearch(int value) {
        ThreadedNode target = null;

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

        ThreadedNode parent = this;

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
