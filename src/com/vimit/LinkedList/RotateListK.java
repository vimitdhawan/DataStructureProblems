package com.vimit.LinkedList;

import com.vimit.LinkedList.Creation.LinkedList;
import com.vimit.LinkedList.Creation.Node;

public class RotateListK {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addElement(1);
        linkedList.addElement(2);
        linkedList.addElement(3);
        linkedList.addElement(4);
        linkedList.addElement(5);

        linkedList.printList();

        linkedList.head = rotate(linkedList.head,2);


        linkedList.printList();

    }

    public static Node rotate(Node head, int k) {
        if(k==0) return head;
        Node lastPointer = head;
        Node hitPointer = head;
        int temp=k-1;
        int maxLength=0;
        while(lastPointer.next != null){
            lastPointer = lastPointer.next;
            if(temp>0){
                hitPointer = hitPointer.next;
                temp--;
            }
            maxLength++;
        }
        if(k>maxLength) return head;

        lastPointer.next = head;
        head = hitPointer.next;
        hitPointer.next = null;
        return head;

    }
}
