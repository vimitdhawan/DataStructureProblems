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
                   newNode.parent = traverseNode;
                   return this.head;
               }
           } else {
               if(traverseNode.left!=null){
                   traverseNode = traverseNode.left;
               } else {
                   traverseNode.left = newNode;
                   newNode.parent = traverseNode;
                   return this.head;
               }

           }
       }
       return this.head;
   }

   public Node find(int data){
       Node node = recursiveFind(data, head);
       return node;
   }

   public Node next(Node node){
       if(node.right !=null){
           return leftDecendent(node.right);
       }
       return rightAncestor(head);
   }

    private Node rightAncestor(Node node) {
       if(node.data < node.parent.data){
           return node;
       }
       return rightAncestor(node.parent);

    }

    private Node leftDecendent(Node node) {
       if(node.left == null)
           return node;
       return leftDecendent(node.left);
    }

    private Node recursiveFind(int data, Node node) {
       if(node.data == data) return node;
       else if(data > node.data){
           if(node.right==null){
               return node;
           }
           return recursiveFind(data, node.right);
       }
       else {
           if(node.left==null){
               return node;
           }
           return recursiveFind(data, node.left);
       }

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
