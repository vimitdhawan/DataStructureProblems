package com.vimit.crackig.coding.LinkedList;


/* package whatever; // don't place package name! */
import java.util.*;


public class RemoveDups
{
    Node head;
    Node temp;
    public void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            temp = node;
        }
        else{
            temp.next = node;
            temp = node;
        }
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            RemoveDups llist = new RemoveDups();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            //llist.printList();
            RemoveDupsSolution g = new RemoveDupsSolution();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends


/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class RemoveDupsSolution
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head)
    {
        Set<Integer> uniqueElements = new HashSet<>();
        Node currentNode = head;
        uniqueElements.add(currentNode.data);
        while(currentNode.next!=null){
            if(uniqueElements.contains(currentNode.next.data)){
                currentNode.next = currentNode.next.next;
            }else{
                uniqueElements.add(currentNode.next.data);
                currentNode = currentNode.next;
            }
        }

        return head;

    }
}

