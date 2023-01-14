package com.vimit.assignments.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IntegerSet {

	private AVLTree<Integer> tree;

    public IntegerSet() {
    	this.tree = new AVLTree<>();
    }
    
    public IntegerSet(int array[]) {
        this.tree = new AVLTree<>();
    	for(int value: array){
            this.tree.add(value);
        }
    }
    
    public int magnitude() {
        return this.tree.getSize();
    }
    
    public void clear() {
    	this.tree.clear();
    }
    
    public boolean isEmpty() {
    	return this.tree.isEmpty();
    }

    public boolean add(int newItem) {
       return this.tree.add(newItem);
    }

    public boolean remove(int itemToRemove) {
        return this.tree.remove(itemToRemove);
    }

    public boolean contains(int itemToFind) {
        AVLTree.Node current = this.tree.root;
        return containsItem(current, itemToFind);
    }

    private boolean containsItem(AVLTree.Node node, int value){
        if(node == null) {
            return false;
        }
        if(node.data.equals(value)){
            return  true;
        } else if(node.data.compareTo(value)>=1){
            return containsItem(node.left, value);
        } else {
            return containsItem(node.right, value);
        }
    }

    public IntegerSet union(IntegerSet other) {
        IntegerSet result = new IntegerSet();
        traversalUnion(result, this.tree.root);
        traversalUnion(result, other.tree.root);
        return result;
    }

    private void traversalUnion(IntegerSet result, AVLTree.Node node){
        if(node == null) return;
        traversalUnion(result, node.left);
        result.add((int)node.data);
        traversalUnion(result, node.right);
    }


    public IntegerSet intersection(IntegerSet other) {
        IntegerSet integerSet = new IntegerSet();
        traversalIntersection(integerSet, other, this.tree.root);
        return integerSet;
    }

    private void traversalIntersection(IntegerSet result, IntegerSet other, AVLTree.Node node){
        if(node == null) return;
        traversalIntersection(result, other, node.left);
        if(other.contains((int)node.data)){
            result.add((int)node.data);
        }
        traversalIntersection(result, other, node.right);
    }
    
    public IntegerSet difference(IntegerSet other) {
        IntegerSet integerSet = new IntegerSet();
        traversalDifference(integerSet, other, this.tree.root);
        return integerSet;
    }

    private void traversalDifference(IntegerSet result, IntegerSet other, AVLTree.Node node){
        if(node == null) return;
        traversalDifference(result, other, node.left);
        if(!other.contains((int)node.data)){
            result.add((int)node.data);
        }
        traversalDifference(result, other, node.right);
    }
    
    public IntegerSet symmetricDifference(IntegerSet other) {
        IntegerSet firstDifference = this.difference(other);
        IntegerSet secondDifference = other.difference(this);
    	return firstDifference.union(secondDifference);
    }
    
    public int getMin() {
        if(this.tree.isEmpty()){
            return Integer.MIN_VALUE;
        }
    	return min(this.tree.root);
    }

    private int min(AVLTree.Node node){
        if(node.left == null){
            return (int)node.data;
        }
        return min(node.left);
    }

    public int getMax() {
        if(this.tree.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return max(this.tree.root);
    }

    private int max(AVLTree.Node node){
        if(node.right == null){
            return (int)node.data;
        }
        return max(node.right);
    }

    public String toString() {
       return this.tree.toString();
    }

    private class AVLTree<T extends Comparable<? super T>> {

        private Node root;
        private int size;

        public void clear() {
            root = null;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean add(T item) {
            boolean added = false;
            if(isEmpty()) {
                root = new Node(item);
                size += 1;
                added = true;
            } else {
                added = add(null, root, item);
            }

            return added;
        }

        private boolean add(Node parent, Node current, T data) {
            boolean added = false;
            if(current == null) {
                int result = data.compareTo(parent.data);

                if(result < 0) {
                    parent.left = new Node(data);
                } else {
                    parent.right = new Node(data);
                }
                size += 1;
                return true;
            } else if(data.compareTo(current.data) < 0) {
                added = add(current, current.left, data);
            } else if(data.compareTo(current.data) > 0) {
                added = add(current, current.right, data);
            } else {
                return false;
            }

            fixHeight(current);

            if(added) {
                rebalance(parent, current);
            }

            return added;
        }

        public boolean remove(T item) {
            if(isEmpty()) {
                return false;
            } else if(size == 1 && root.data.equals(item)) {
                clear();
                return true;
            } else if(removeTraversal(null, root, item)){
                size -= 1;
                return true;
            } else {
                return false;
            }
        }

        private boolean removeTraversal(Node parent, Node current, T data) {
            boolean removed = true;
            if(current == null) {
                return false;
            } else if(data.compareTo(current.data) < 0) {
                removed = removeTraversal(current, current.left, data);
            } else if(data.compareTo(current.data) > 0) {
                removed = removeTraversal(current, current.right, data);
            } else {
                removeNode(parent, current);
            }

            fixHeight(current);

            if(removed) {
                rebalance(parent, current);
            }

            return removed;
        }

        private void removeNode(Node parent, Node current) {
            if(current.left == null && current.right == null) {
                //Remove leaf node
                removeCase1(parent, current);
            } else if(current.left != null && current.right == null) {
                //Remove node with no right child
                removeCase2(parent, current);
            } else if(current.left == null && current.right != null) {
                //Remove node with no left child
                removeCase3(parent, current);
            } else {
                //Remove node with both children
                removeCase4(parent, current);
            }

            fixHeight(parent);

        }

        private void removeCase1(Node parent, Node current) {
            if(parent == null) {
                root = null;
            } else if(parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        private void removeCase2(Node parent, Node current) {
            if(parent == null) {
                root = root.left;
            } else if(parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
            current.left = null;
        }

        private void removeCase3(Node parent, Node current) {
            if(parent == null) {
                root = root.right;
            } else if(parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
            current.right = null;
        }

        private void removeCase4(Node parent, Node current) {
            Node leftMost = current.right;
            Node leftMostParent = current;

            while(leftMost.left != null) {
                leftMostParent = leftMost;
                leftMost = leftMost.left;
            }

            current.data = leftMost.data;

            removeNode(leftMostParent, leftMost);
            rebalance(current, current.right);
        }

        public int getHeight() {
            return getHeight(root);
        }

        private int getHeight(Node node) {
            if(node == null) {
                return -1;
            }

            return Math.max(node.leftHeight, node.rightHeight);
        }

        private void fixHeight(Node node) {
            if(node != null) {
                node.leftHeight = getHeight(node.left) + 1;
                node.rightHeight = getHeight(node.right) + 1;
            }
        }

        private int balance(Node node) {
            //If the balance > 1 the imbalance is in the left subtree
            //If the balance < -1 the imbalance is in the right subtree
            return node.leftHeight - node.rightHeight;
        }

        private Node rightRotation(Node n) {
            Node c = n.left;
            Node t2 = c.right;

            c.right = n;
            n.left = t2;

            fixHeight(n);
            fixHeight(c);

            return c;
        }

        private Node leftRotation(Node n) {
            Node c = n.right;
            Node t2 = c.left;

            c.left = n;
            n.right = t2;

            fixHeight(n);
            fixHeight(c);

            return c;
        }

        private void rebalance(Node parent, Node node) {
            if(node == null) {
                return;
            }

            //Imbalance in left subtree
            if(balance(node) > 1) {
                //Handles case III
                if(balance(node.left) < 0) {
                    node.left = leftRotation(node.left);
                }
                if(parent == null) {
                    root = rightRotation(node);
                } else if(parent.left == node) {
                    parent.left = rightRotation(node);
                } else {
                    parent.right = rightRotation(node);
                }
                //Imbalance in right subtree
            } else if(balance(node) < -1) {
                //Handles case IV
                if(balance(node.right) > 0) {
                    node.right = rightRotation(node.right);
                }

                if(parent == null) {
                    root = leftRotation(node);
                } else if(parent.left == node) {
                    parent.left = leftRotation(node);
                } else {
                    parent.right = leftRotation(node);
                }
            }
        }

        @Override
        public String toString() {
            return levelOrderString();
        }

        public String levelOrderString() {
            StringBuffer sb = new StringBuffer();

            sb.append("{");

            if(!isEmpty()) {
                Queue<Node> q = new LinkedList<>();

                q.add(root);
                Node current = null;

                while(!q.isEmpty()) {

                    current = q.remove();
                    if(current.left != null) {
                        q.add(current.left);
                    }

                    if(current.right != null) {
                        q.add(current.right);
                    }

                    sb.append(current);
                    if(!q.isEmpty()) {
                        sb.append(", ");
                    }
                }

            }

            sb.append("}");

            return sb.toString();
        }

        private class Node {
            private Node left;
            private Node right;

            private int leftHeight;
            private int rightHeight;

            private T data;

            public Node(T data) {
                this.data = data;
            }

            public String toString() {
                String formatter = "(%s | %s | %s)";
                String leftString = left != null ? left.data.toString() : "";
                String rightString = right != null ? right.data.toString() : "";
                return String.format(formatter, data.toString(), leftString, rightString);
            }
        }
    }











}

