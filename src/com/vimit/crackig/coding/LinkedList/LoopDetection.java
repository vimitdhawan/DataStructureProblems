package com.vimit.crackig.coding.LinkedList;


// driver code

/* input format
        1 => test cases
        3 => no of nodes value
        1 3 4 => nodes value
        2 => loop node
        */

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

public class LoopDetection
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, pos);

            solver x = new solver();
            x.removeLoop(head);

            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class solver
{
    public static void removeLoop(Node head){
        if(head==null) return;
        Node collidePrevNode = getCollideNode(head);
        Node slowPointer = head;
        if(collidePrevNode!=null){
            Node collideNode  = collidePrevNode.next;
            while(slowPointer != collideNode){
                collidePrevNode = collideNode;
                collideNode = collideNode.next;
                slowPointer = slowPointer.next;

            }
            collidePrevNode.next = null;


        }


    }

    private static Node getCollideNode(Node node){
        Node slowPointer = node;
        Node fastPointer = node;
        Node collidePrevNode = null;
        while(fastPointer!= null && fastPointer.next!=null){
            collidePrevNode = fastPointer.next;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(fastPointer == slowPointer){
                return collidePrevNode;
            }

        }
        return null;
    }
}// } Driver Code Ends