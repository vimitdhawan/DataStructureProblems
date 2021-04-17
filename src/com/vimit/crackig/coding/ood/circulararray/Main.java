package com.vimit.crackig.coding.ood.circulararray;

public class Main {
    public static void main(String[] args) {
        CircularArray<Integer> circularArray = new CircularArrayImpl<>(5);
        circularArray.add(5);
        circularArray.add(10);
        circularArray.rotateLeft(2);
        System.out.println(circularArray.get(2));
    }
}
