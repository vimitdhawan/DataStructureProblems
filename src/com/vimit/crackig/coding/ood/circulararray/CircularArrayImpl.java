package com.vimit.crackig.coding.ood.circulararray;

import java.util.Arrays;
import java.util.Iterator;

public class CircularArrayImpl<T> implements CircularArray<T> {
    private T[] items;
    private int head;
    private int currentSize;
    public CircularArrayImpl(int size){
        items = (T[]) new Object[size];
        head = 0;
        currentSize = 0;
    }


    @Override
    public T get(int index) {
        return items[rotateIndex(index)];
    }

    @Override
    public void rotateRight(int shift) {
        this.head = rotateIndex(shift);
    }

    @Override
    public void rotateLeft(int shift) {
        this.head = rotateIndex(-shift);
    }

    @Override
    public void add(T item) {
        items[currentSize] = item;
        currentSize++;
    }

    @Override
    public void delete(int index) {
        items[rotateIndex(index)] = null;
    }

    private int rotateIndex(int index){
        if (index < 0) {
            index+= items.length;
        }
        return (head + index) % items.length;
    }

    @Override
    public String toString() {
        return "CircularArrayImpl{" +
                "items=" + Arrays.toString(items) +
                ", head=" + head +
                ", currentSize=" + currentSize +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<>(items);
    }

    private class CircularArrayIterator<TI> implements Iterator<TI>{
        private int _current = 0;
        private TI[] _items;
        public CircularArrayIterator(TI[] arr){
            _items = arr.clone();
        }
        @Override
        public boolean hasNext() {
            return _current <_items.length;
        }

        @Override
        public TI next() {
            TI item = _items[rotateIndex(_current)];
            _current++;
            return item;
        }
    }
}
