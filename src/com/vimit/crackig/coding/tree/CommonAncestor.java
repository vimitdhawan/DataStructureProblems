package com.vimit.crackig.coding.tree;

/*
1
2 3
1 2 3
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
        import java.io.*;


public class CommonAncestor  {

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
    static void printInorder(Node root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String input[] = br.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            String s = br.readLine();
            Node root = buildTree(s);
            CoomonAncestorTree g = new CoomonAncestorTree();
            Node k = g.lca(root,a,b);
            System.out.println(k.data);

        }
    }
}
// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class CoomonAncestorTree
{

    /* If n1 and n2 are present, return reference
       to LCA. If both are not present, return
       null,. Else if left subtree contains any
       of them return pointer to left.*/
    Node lca(Node root, int n1,int n2)
    {
        if(n1>n2){
            return getAncestor(root, n2, n1);
        }else{
            return getAncestor(root, n1, n2);
        }
    }


    Node getAncestor(Node node, int a, int b){
        if(node == null) return null;
        if(a>node.data && b>node.data){
            return getAncestor(node.right, a, b);
        } else if(a<node.data && b<node.data){
            return getAncestor(node.left, a, b);
        }
        return node;
    }

    public Node lowestCommonAncestorBinaryTree(Node root, int p, int q) {
        List<Node> leftParent = new ArrayList<>();
        List<Node> rightParent = new ArrayList<>();
        findParent(root, p, leftParent);
        findParent(root, q, rightParent);
        int k =1;
        while(k<leftParent.size() && k<rightParent.size()){
            if(leftParent.get(k).data != rightParent.get(k).data){
                break;
            }
            k++;
        }

        return leftParent.get(k-1);


    }

    public boolean findParent(Node node, int value, List<Node> parents){
        if(node == null) return false;
        parents.add(node);
        if(node.data == value) return true;
        if(findParent(node.left, value, parents)  || findParent(node.right, value, parents)) return true;
        parents.remove(node);
        return false;
    }


}

