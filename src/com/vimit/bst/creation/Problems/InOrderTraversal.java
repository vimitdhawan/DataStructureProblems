package com.vimit.bst.creation.Problems;

import com.vimit.bst.creation.BST;
import com.vimit.bst.creation.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
       BST bst =  BST.createBst();
        bst.inOrderTraversal(bst.head);
       List<Integer> result = inorderTraversal(bst.head);
       System.out.println(result);
    }

    public static List<Integer> inorderTraversal(Node root) {

        Node currentNode = root;
        List<Integer> output = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        traverseLeft(currentNode, stack);
        Node node =null;
        if(!stack.isEmpty())
            node = stack.pop();
        while(node != null){
            output.add(node.data);
            traverseLeft(node.right, stack);
            if(!stack.isEmpty()){
                node = stack.pop();
            } else{
                node =null;
            }

        }
        return output;

    }

    private static void traverseLeft(Node currentNode, Stack<Node> stack) {
        while(currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
    }

}
