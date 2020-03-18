package dataStructure;

import java.util.Arrays;

/**
 * 面向对象的数组
 * 扩展：集合的底层实现原理
 */
public class Demo2 {

    private int[] elements;

    public Demo2() {
        elements = new int[0];
    }

    /**
     * 获取数组的长度
     *
     * @return
     */
    public int size() {
        return elements.length;
    }

    /**
     * 往数组中添加一个元素
     *
     * @param val
     */
    public void add(int val) {
        int[] newArray = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        newArray[newArray.length - 1] = val;
        elements = newArray;
    }

    /**
     * 删除某个元素
     *
     * @param index 删除元素的下标,从0开始
     */
    public void remove(int index) {

        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组下标越界");
        }

        int[] newArray = new int[elements.length - 1];

        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = elements[i];
            } else {
                newArray[i] = elements[i + 1];
            }
        }

        elements = newArray;

    }

    /**
     * 向指定位置插入一个元素
     *
     * @param val   插入的值
     * @param index 插入的位置 从0开始
     */
    public void insert(int val, int index) {

        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组下标越界");
        }

        int[] newArray = new int[elements.length + 1];

        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = elements[i];
            } else if (i == index) {
                newArray[i] = val;
            } else {
                newArray[i] = elements[i - 1];
            }
        }

        elements = newArray;
    }

    /**
     * 打印数组
     */
    public void print() {
        System.out.println(Arrays.toString(elements));
    }


}
