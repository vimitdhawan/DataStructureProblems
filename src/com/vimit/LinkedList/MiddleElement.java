package com.vimit.LinkedList;

import com.vimit.LinkedList.Creation.LinkedList;
import com.vimit.LinkedList.Creation.Node;

public class MiddleElement {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addElement(1);
        linkedList.addElement(2);
        linkedList.addElement(3);
        linkedList.addElement(4);
        linkedList.addElement(5);

        System.out.println(getMiddle(linkedList.head));

    }

   private static Integer getMiddle(Node<Integer> head)
    {
        Node<Integer> slowPointer = head;
        Node<Integer> fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.getData();
    }
}
