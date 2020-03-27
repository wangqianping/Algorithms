package test;

import algorithm.SortingAlgorithm;

import java.util.Arrays;

public class TestSortingAlgorithm {

    public static void main(String[] args) {
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        int[] array = new int[]{3,1,2,5,4,6 };
        System.out.println("原数组 "+Arrays.toString(array));
//        sortingAlgorithm.bubbleSort(array);
//        sortingAlgorithm.quickSort(array,0,array.length-1);
//        sortingAlgorithm.insertSort(array);
//        sortingAlgorithm.shellSort(array);
//        sortingAlgorithm.shellSort(array);
//        sortingAlgorithm.mergeSort(array,0,5);
//        sortingAlgorithm.RedixSort(array);
//        sortingAlgorithm.RedixQueueSort(array);
        sortingAlgorithm.heapSort(array);
        System.out.println("排序后 "+Arrays.toString(array));

    }








}
