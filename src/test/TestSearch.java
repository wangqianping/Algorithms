package test;

import algorithm.Search;

public class TestSearch {

    public static void main(String[] args) {
        Search search = new Search();
        int index = search.linearSearch(1);
        System.out.println(index);

        index = search.BinarySearch(0);
        System.out.println(index);
    }


}
