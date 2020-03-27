package dataStructure.linkedList;

/**
 * 单链表
 * 链式存储结构，每一节点分成两部分，一部分存储本身的值另一部分存储下一个节点的地址
 * 扩展知识点：
 * 对于Java来说，所谓的地址其实就是对象本身，基本类型存储的是值，引用类型存储的都是地址
 * ，所以当前类的属性next是一个对象，但是我们说成存储的是下一个对象的地址
 */
public class Node {

    private int data;
    private Node next;//下一个对象的地址


    public Node(int data) {
        this.data = data;
    }

    /**
     * 追加节点,
     */
    public Node append(Node next) {

        Node current = this;

        //如果当前节点有下一节点就一直循环，直到找到最后一个节点
        while (current.hasNext()) {
            current = current.next;
        }

        current.next = next;

        return current;
    }

    /**
     * 删除下一个节点，单链表只能删除下一个节点
     */
    public void removeNext() {
        //取出下下个节点
        Node node = next.next;
        //将下下个节点赋值给当前节点的下一个节点
        next = node;
    }

    /**
     * 插入一个节点，单链表只能往后插入一个新节点
     */
    public void insert(Node node){
        //下一节点作为当前节点的下一节点
        node.next = next;
        //要插入的节点作为当前节点的下一个节点
        this.next = node;
    }

    /**
     * 获取下一个节点
     */
    public Node next() {
        return next;
    }

    /**
     * 获取节点中的数据
     */
    public int getData() {
        return this.data;
    }

    /**
     * 判断当前节点是否是最后一个节点
     */
    public boolean hasNext() {
        return next != null;
    }

    /**
     * 打印所有节点
     *
     * @return
     */
    public void show() {

        Node current = this;

        while (current.hasNext()) {
            System.out.print(current.data + ",");
            current = current.next;
        }

        System.out.println(current.getData());

    }


}
