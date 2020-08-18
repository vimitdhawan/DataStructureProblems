package com.vimit.bst.creation.Problems;

import com.vimit.bst.creation.BST;
import com.vimit.bst.creation.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
       BST bst =  BST.createBst();
       List<Integer> result = inorderTraversal(bst.head);
    }

    public static List<Integer> inorderTraversal(Node root) {

        Node currentNode = root;
        List<Integer> output = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        traverseLeft(currentNode, stack);
        Node node = stack.pop();
        while(node != null){
            output.add(node.data);
            traverseLeft(node.right, stack);
            node = stack.pop();
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
