package dataStructure;

/**
 * 循环链表
 * <p>
 * 和单链表唯一的区别就是最后一个节点指向第一个节点
 */
public class LoopNode {

    private int data;
    private LoopNode next = this;


    public LoopNode(int data) {
        this.data = data;
    }

    /**
     * 删除下一个节点
     */
    public void removeNext() {
        //取出下下个节点
        LoopNode node = next.next;
        //将下下个节点赋值给当前节点的下一个节点
        next = node;
    }

    /**
     * 插入一个节点
     */
    public void insert(LoopNode node) {
        //下一节点作为当前节点的下一节点
        node.next = next;
        //要插入的节点作为当前节点的下一个节点
        this.next = node;
    }

    /**
     * 获取下一个节点
     */
    public LoopNode next() {
        return next;
    }

    /**
     * 获取节点中的数据
     */
    public int getData() {
        return this.data;
    }


}
