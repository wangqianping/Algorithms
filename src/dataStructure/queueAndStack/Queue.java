package dataStructure.queueAndStack;

/**
 * 队列
 *
 * 其特点是先进先出
 */
public class Queue {

    private int[] elements;

    public Queue() {
        elements = new int[0];
    }


    /**
     * 入队
     *
     * @param val
     */
    public void add(int val) {

        int[] array = new int[elements.length + 1];

        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
        }

        array[array.length - 1] = val;
        elements = array;

    }

    /**
     * 出队
     *
     * @return
     */
    public int poll() {

        if (elements.length <= 0) {
            throw new RuntimeException("queue is empty");
        }

        int element = elements[0];

        int[] array = new int[elements.length - 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = elements[i + 1];
        }

        elements = array;

        return element;

    }


}
