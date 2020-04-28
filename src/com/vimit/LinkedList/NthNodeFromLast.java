package com.vimit.LinkedList;

import com.vimit.LinkedList.Creation.LinkedList;
import com.vimit.LinkedList.Creation.Node;

public class NthNodeFromLast {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addElement(1);
        linkedList.addElement(2);
        linkedList.addElement(3);
        linkedList.addElement(4);
        linkedList.addElement(5);
        Node result = getNFromLast(linkedList.head, 2);
        System.out.println(result.getData());
    }

    private static Node getNFromLast(Node<Integer> head, int n) {

        Node slowPointer = head;
        Node fastPointer = head;
        while(n>0){
            if(fastPointer==null) return null;
            fastPointer = fastPointer.next;
            n--;
        }
        while(fastPointer!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}
