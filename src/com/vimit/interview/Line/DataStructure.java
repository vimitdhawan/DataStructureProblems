package com.vimit.interview.Line;

import java.util.*;

public class DataStructure {
    public static void main(String[] args) {
        String[] arr = {"add 5 3", "add 1 2", "get 5", "evict", "get 1", "remove 5", "exit'"};
        DataStructure ds = new DataStructure();
        System.out.print(Arrays.toString(ds.solution(arr)));
    }

    public String[] solution(String[] n) {
        LRUCache<Integer, Integer> lruCache  = new LRUCache<>(n.length);
        List<String> list = new ArrayList<>();
        boolean isExit = false;
        for(int i = 0; i<n.length; i++){
            String[] detailArr = n[i].split("\\s+");
            if(detailArr.length>0){
                switch (detailArr[0]){
                    case "add":
                        if(validLength(3, detailArr))
                        lruCache.set(Integer.parseInt(detailArr[1]), Integer.parseInt(detailArr[2]));
                        break;
                    case "get":
                        if(validLength(2, detailArr)){
                            Integer value = lruCache.get(Integer.parseInt(detailArr[1]));
                            addValue(list, value);
                        }
                        break;
                    case "evict":
                        lruCache.evict();
                        break;
                    case "remove":
                        if(validLength(2, detailArr)){
                            Integer removeValue = lruCache.removeKey(Integer.parseInt(detailArr[1]));
                            addValue(list, removeValue);
                        }
                        break;
                    case "exit":
                        isExit = true;
                        break;
                    default:
                        break;
                }
                if(isExit) break;
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private boolean validLength(int size, String[] arr){
        return arr.length == size;
    }

    private void addValue(List<String> list, Integer value){
        if(value == null){
            list.add(String.valueOf("-1"));
        } else {
            list.add(String.valueOf(value));
        }
    }


}

class LRUCache<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K, Node<K, V>> map;
    private int size;

    public LRUCache(int cap) {
        map = new HashMap<>(size);
        this.size = cap;

    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            removeNode(node);
            moveNodeAtTop(node);
            return map.get(key).value;
        }
        return null;


    }

    public void set(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        removeKey(key);
        if (map.size() >= size) {
            removeKey(tail.key);
        }
        moveNodeAtTop(node);
        map.put(key, node);

    }

    public V removeKey(K key) {
        Node<K, V> temp = map.get(key);
        removeNode(temp);
        Node<K, V> removeNode = map.remove(key);
        if(removeNode != null){
            return removeNode.value;
        }
        return null;
    }

    public void evict(){
            if(tail!=null){
                removeKey(tail.key);
            }
    }


    private void removeNode(Node<K, V> node) {
        if (node == null) return;
        if (node.previous != null) {
            node.previous.next = node.next;

        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        if (node == tail) {
            tail = node.previous;
        }
        if (node == head) {
            head = node.next;
        }
    }

    private void moveNodeAtTop(Node<K, V> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }

    }

    private static class Node<K, V> {
        Node<K, V> next;
        Node<K, V> previous;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}