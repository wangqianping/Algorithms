package test;

import dataStructure.array.ArrayObject;

public class TestArrayObject {

    public static void main(String[] args){

        ArrayObject demo = new ArrayObject();
        System.out.println("长度："+demo.size());
        demo.add(1);
        demo.add(2);

        demo.print();

        demo.remove(1);
        demo.print();

        demo.add(2);
        demo.add(3);
        demo.add(5);

        demo.print();

        demo.insert(4,3);
        demo.print();
    }
}
