package com.vimit.crackig.coding.LinkedList;


//Initial Template for Java

import java.util.*;
        import java.lang.*;


//Initial Template for Java


class PartitionNode {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            PartitionSolution ob = new PartitionSolution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class PartitionSolution {
    public static Node partition(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        while(node != null){
            if(node.data<x){
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = node;
                } else{
                    beforeEnd.next = node;
                    beforeEnd = node;
                }

            } else {
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = node;
                }else if(node.data>x){
                    afterEnd.next = node;
                    afterEnd = node;
                } else{
                    Node tempNode = new Node(node.data);
                    tempNode.next = afterStart;
                    afterStart = tempNode;
                }
            }
            node = node.next;

        }
        if(beforeStart != null && afterStart!=null){
            beforeEnd.next = afterStart;
            afterEnd.next = null;
        } else if(beforeStart != null){
            beforeEnd.next =null;
        } else if(afterStart!=null){
            beforeStart = afterStart;
            afterEnd.next = null;
        }

        return beforeStart;
    }
}