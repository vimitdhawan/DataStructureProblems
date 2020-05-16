package com.vimit.bst.creation;

public class BST {
   public Node head;
   public BST(){
        this.head = null;
    }

    public Node addElement(int data){
       Node newNode = new Node(data);
       if(head == null){
           this.head = newNode;
           return head;
       }
       Node traverseNode = this.head;

       while(traverseNode != null){
           if(newNode.data>traverseNode.data){
               if(traverseNode.right!=null){
                   traverseNode = traverseNode.right;
               } else {
                   traverseNode.right = newNode;
                   return this.head;
               }
           } else {
               if(traverseNode.left!=null){
                   traverseNode = traverseNode.left;
               } else {
                   traverseNode.left = newNode;
                   return this.head;
               }

           }
       }
       return this.head;
   }

   public void inOrderTraversal(Node temp) {
       if(temp.left!=null){
           inOrderTraversal(temp.left);
       }
       System.out.println(temp.data);
       if(temp.right!=null) {
           inOrderTraversal(temp.right);
       }
   }

   public static BST createBst() {
       BST bst = new BST();
       bst.addElement(10);
       bst.addElement(5);
       bst.addElement(7);
       bst.addElement(1);
       bst.addElement(12);
       bst.addElement(15);
       return bst;
   }

}
