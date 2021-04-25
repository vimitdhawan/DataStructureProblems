package com.vimit.crackig.coding.tree;

import java.util.ArrayList;
import java.util.List;

// Definition of TreeNode:
  class TreeNode {
    public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
        this.val = val;
         this.left = this.right = null;
     }
}

// Definition for singly-linked list.
 class ListNode {
    int val;
 ListNode next;
 ListNode(int x) { val = x; }
  }

public class BinaryTreeLLDepth {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> list = new ArrayList<>();
        traverse(root, 0, list);
        return list;
    }
    public void traverse(TreeNode node, int height, List<ListNode> list){
        StringBuilder s1 = new StringBuilder(Integer.MAX_VALUE);
        if(node == null) return;
        ListNode listnode = new ListNode(node.val);
        ListNode headNode = null;
        if(list.size()>=height+1){
            headNode = list.get(height);
        }
        if(headNode == null){
            list.add(listnode);
        } else {
            while(headNode.next != null){
                headNode = headNode.next;
            }
            headNode.next = listnode;
        }
        traverse(node.left, height+1, list);
        traverse(node.right, height+1, list);
    }



}