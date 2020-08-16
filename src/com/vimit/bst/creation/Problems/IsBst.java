package com.vimit.bst.creation.Problems;

import com.vimit.bst.creation.BST;
import com.vimit.bst.creation.Node;

public class IsBst {
    public static void main(String[] args) {
       BST bst =  BST.createBst();
       boolean isBst = isBST(bst.head);
    }

    static boolean isBST(Node root){
        return checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    static boolean checkBst(Node node, int minValue, int maxValue){
        if(node==null) return true;
        if(node.data<=minValue || node.data>maxValue) return false;
        else return checkBst(node.right, node.data, maxValue) && checkBst(node.left, minValue, node.data);
    }
}
