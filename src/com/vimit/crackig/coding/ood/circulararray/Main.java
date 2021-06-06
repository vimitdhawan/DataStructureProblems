package com.vimit.crackig.coding.ood.circulararray;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CircularArray<Integer> circularArray = new CircularArrayImpl<>(5);
        circularArray.add(5);
        circularArray.add(10);
        circularArray.rotateLeft(2);
        Iterator<Integer> circularIterator = circularArray.iterator();
        while(circularIterator.hasNext()){
            System.out.println(circularIterator.next());
        }
        System.out.println(circularArray.get(2));
    }
}
