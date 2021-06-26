package com.vimit.leetcode.design.lru;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));

    }
}
class LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        join(head, tail);
    }

    private void join(Node node1, Node node2){
        node1.next = node2;
        node2.prev = node1;
    }

    private void joinBetweenNode(Node node1, Node node2, Node node3){
        node2.prev = node1;
        node2.next = node3;
        node1.next.prev = node2;
        node1.next = node2;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            moveNodeAtTop(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        removeKey(key);
        if(map.size() == this.capacity && tail!=null){
            removeKey(getLast().key);
        }
        Node node = new Node(key, value);
        moveNodeAtTop(node);
        map.put(key, node);
    }

    private void removeKey(int key){
        Node node = map.get(key);
        removeNode(node);
        map.remove(key);
    }

    public void removeNode(Node node){
        if (node == null || node.prev == null || node.next == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveNodeAtTop(Node node){
      if(node == null) return;
      joinBetweenNode(head, node, head.next);
    }

    public Node getLast() {
        if (head.next == tail) {
            return null; // list has 0 Nodes
        }
        return tail.prev;
    }

    private class Node{
        Node next;
        Node prev;
        int value;
        int key;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}