package com.vimit.crackig.coding.ood.circulararray;

public interface CircularArray<T> {

    T get(int index);

    void rotateRight(int shift);

    void rotateLeft(int shift);

    void add(T item);

    void delete(int index);


}
