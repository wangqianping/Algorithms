package test;

import algorithm.SortingAlgorithm;

import java.util.Arrays;

public class TestSortingAlgorithm {

    public static void main(String[] args) {
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        int[] array = new int[]{3,1,4,2,6,5};
//        sortingAlgorithm.bubbleSort(array);
//        sortingAlgorithm.quickSort(array,0,array.length-1);
        sortingAlgorithm.insertSort(array);
        System.out.println(Arrays.toString(array));

    }








}
