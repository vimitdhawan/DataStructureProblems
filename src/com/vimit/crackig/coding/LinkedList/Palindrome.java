package com.vimit.crackig.coding.LinkedList;


import java.util.*;
// 1 <- Test Cases
// 3 <-no of nodes
// 1 2 1 <- node values

public class Palindrome
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

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            //int k = sc.nextInt();
            Palindrome llist = new Palindrome();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            Solution g = new Solution();
            if(g.isPalindrome(head) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }

    }
}




// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;

	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    Node forwardElement = null;

    boolean isPalindrome(Node head)
    {
        int size = getSize(head);
        return isPalindromeTraverse(head, size);
    }

    boolean isPalindromeTraverse(Node node, int size){
        if(size == 0){
            forwardElement = node;
            return true;
        } else if(size == 1){
            forwardElement = node.next;
            return true;
        }
        boolean isPalindrome = isPalindromeTraverse(node.next, size-2);
        if(isPalindrome && forwardElement.data == node.data){
            forwardElement = forwardElement.next;
            return true;
        }

        return false;
    }

    int getSize(Node node){
        int size =0;
        while(node !=null){
            size++;
            node = node.next;
        }
        return size;

    }
}

