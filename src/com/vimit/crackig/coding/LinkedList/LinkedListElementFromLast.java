package com.vimit.crackig.coding.LinkedList;


import java.util.*;



public class LinkedListElementFromLast
{
    Node head;
    Node tail;
    /* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            tail = node;
        } else
        {
            tail.next = node;
            tail = node;
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            LinkedListElementFromLast llist = new LinkedListElementFromLast();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            //System.out.println(llist.head.data);
            SolutionLast g = new SolutionLast();
            //System.out.println(k);
            System.out.println(g.getNthFromLast(llist.head,k));

            t--;
        }
    }
}



// } Driver Code Ends


/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class SolutionLast
{
    //Function to find the data of nth node from the end of a linked list.
    static int count =0;
    int getNthFromLast(Node head, int n)
    {
        count =0;
        Node node = getNthNode(head, n);
        if(node == null) return -1;
        else return node.data;
        // Your code here
    }

    Node getNthNode(Node node, int n){
        if(node == null) return null;
        else{
            Node temp = getNthNode(node.next, n);
            count++;
            if(count == n){
                temp = node;
            }
            return temp;
        }
    }
}
