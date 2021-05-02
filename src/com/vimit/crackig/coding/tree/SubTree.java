package com.vimit.crackig.coding.tree;

//Initial Template for Java

/*
1
1 2 3 N N 4
3 4
*/

import java.util.LinkedList;
        import java.util.Queue;
        import java.io.*;


public class SubTree{

    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String tt= br.readLine();
            Node rootT = buildTree(tt);

            String s= br.readLine();
            Node rootS = buildTree(s);
            // printInorder(root);

            SubtreeSolution tr=new SubtreeSolution();
            boolean st=tr.isSubtree(rootT, rootS);
            if(st==true){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*complete the given function*/

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class SubtreeSolution {
    public static boolean isSubtree(Node T, Node S) {
        if(T==null) return false;
        if(T.data == S.data && matchTree(T, S)) return true;
        else return (isSubtree(T.left, S) || isSubtree(T.right, S));
    }

    public static boolean matchTree(Node T, Node S){
        if(T == null && S == null) return true;
        if(T == null || S == null) return false;
        if(T.data != S.data) return false;
        else return matchTree(T.left, S.left) && matchTree(T.right, S.right);
    }
}