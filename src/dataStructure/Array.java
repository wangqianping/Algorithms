package dataStructure;

import java.util.Arrays;

/**
 * 数据结构之线性结构——数组
 * <p>
 * 顺序存储结构
 */

public class Array {

    public static void main(String[] args) {
        //创建一个数组
        int[] array = new int[3];
        int[] array2 = new int[]{1, 2, 3};

        //获取数据的长度
        System.out.println(array.length);
        //访问数组中的元素
        System.out.println(array[0]);
        //赋值
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }

        //数组扩容
        array = ArrayExpansion(array, 4);
        System.out.println("数组扩容" + Arrays.toString(array));

        //删除数组指定位置的元素
        array = delelteElement(array,4);
        System.out.println("删除指定位置的元素："+Arrays.toString(array));
    }


    /**
     * 数组扩容
     *
     * @param array 原数组
     * @param val   待插入的元素,直接插入到最后
     * @return
     */
    public static int[] ArrayExpansion(int[] array, int val) {

        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[newArray.length - 1] = val;

        array = newArray;

        return array;

    }

    /**
     * 删除数组中的元素
     *
     * @param array 目标数组
     * @param index 删除元素的下标
     * @return
     */
    public static int[] delelteElement(int[] array,int index){

        if(index>array.length){
            throw new RuntimeException("下标越界");
        }

        int[] arr = new int[array.length-1];

        for(int i=0;i<arr.length;i++){
            if(i<index-1){
                arr[i] = array[i];
            }else if(i>=index-1){
                arr[i] = array[i+1];
            }
        }

        array = arr;
        return array;

    }


}
