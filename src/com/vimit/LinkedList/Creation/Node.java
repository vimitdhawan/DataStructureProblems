package com.vimit.LinkedList.Creation;

public class Node<T> {
    T data;
    public Node next;
    Node(T data){
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }
}
