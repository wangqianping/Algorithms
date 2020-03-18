package dataStructure;

/**
 * 栈
 * 栈也是一种顺序存储的数据结构，他的特殊性就在于先入后出
 */
public class Demo3 {

    private int[] elements;

    public Demo3() {
        elements = new int[0];
    }

    /**
     * 压入一个数据
     *
     * @param val
     */
    public void push(int val) {

        int[] array = new int[elements.length + 1];

        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
        }

        array[array.length - 1] = val;
        elements = array;

    }

    /**
     * 取出栈顶元素
     */
    public int pop() {

        if (elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }

        int[] array = new int[elements.length - 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = elements[i];
        }

        int result = elements[elements.length - 1];

        elements = array;

        return result;

    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public int peek() {

        if (elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        return elements[elements.length - 1];
    }


}
