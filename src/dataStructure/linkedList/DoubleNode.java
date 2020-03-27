package dataStructure.linkedList;

/**
 * 双向链表
 * 在单链表的基础上再增加一部分用来存储上一个节点的地址
 *
 * 当前类展示的是双向循环链表
 */
public class DoubleNode {

    private DoubleNode previous = this;
    private int data;
    private DoubleNode next = this;

    public DoubleNode(int data){
        this.data = data;
    }

    /**
     * 插入一个节点
     */
    public void insert(DoubleNode doubleNode){

        //当前节点的下一个节点的前一个节点为要插入的节点
        next.previous = doubleNode;
        //要插入的节点的下一个节点为当前节点的下一个节点
        doubleNode.next = next;
        //要插入节点的前一个节点为当前节点
        doubleNode.previous = this;
        //当前节点的下一个节点为要插入的节点
        this.next = doubleNode;

    }

    /**
     * 获取下一个节点
     */
    public DoubleNode next() {
        return next;
    }

    /**
     * 获取上一个节点
     */
    public DoubleNode previous(){
        return previous;
    }

    /**
     * 获取值
     */
    public int getData() {
        return data;
    }
}
