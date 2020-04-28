package com.vimit.LinkedList.Creation;

public class LinkedList<T> {
    public Node<T> head;
    public LinkedList() {
        head = null;
    }

    public Node addElement(T data){
        Node<T> node = new Node<>(data);
        if(head == null){
            head = node;
        } else {
            Node temp = head;
            while(temp != null){
                if(temp.next == null){
                    temp.next = node;
                    temp = node.next;
                } else {
                    temp = temp.next;
                }

            }
        }
        return head;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.getData());
            temp = temp.next;
        }

    }

}
