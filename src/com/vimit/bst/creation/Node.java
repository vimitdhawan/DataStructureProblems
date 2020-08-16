package com.vimit.bst.creation;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
