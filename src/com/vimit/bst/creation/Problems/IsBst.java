package com.vimit.bst.creation.Problems;

import com.vimit.bst.creation.BST;
import com.vimit.bst.creation.Node;

public class IsBst {
    public static void main(String[] args) {
       BST bst =  BST.createBst();
       boolean isBst = traverse(bst.head);
    }

    private static boolean traverse(Node node) {
        return true;
    }
}
