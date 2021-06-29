package com.vimit.interview.miro;


import java.util.*;

public class LRUCache {
    private LL list = new LL();
    private Map<Integer, ListNode> map;
    private int capacity;
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
      if(map.containsKey(key)){
          ListNode node = map.get(key);
          list.removeNode(Optional.of(node));
          list.addFirst(Optional.of(node));
          return node.getValue();
      }
      return -1;
    }
    public void put(int key, int value) {
        ListNode newNode = new ListNode(key, value);
        ListNode node = map.get(key);
        list.removeNode(Optional.ofNullable(node));
        map.remove(key);
        if(map.size() == capacity && list.tail.isPresent()){
            map.remove(list.tail.get().getKey());
            list.removeNode(list.tail);
        }
        list.addFirst(Optional.of(newNode));
        map.put(key, newNode);
    }


}

class LL {
    public Optional<ListNode> head = Optional.empty();
    public Optional<ListNode> tail = Optional.empty();

    public void removeNode(Optional<ListNode> node){
        if(node.isPresent()){
            if(node.get().prev.isPresent()){
                node.get().prev.get().next = node.get().next;
            }
            if(node.get().next.isPresent()){
                node.get().next.get().prev = node.get().prev;
            }
            if(node.get() == head.get()){
                head = node.get().next;
            }
            if(node.get() == tail.get()){
                tail = node.get().prev;
            }
        }
    }

    public void addFirst(Optional<ListNode> node){
        if(node.isPresent()){
            if(head.isPresent()){
                node.get().next = head;
                head.get().prev = node;
                head = node;
                node.get().prev = Optional.empty();
            }else{
                head = node;
                tail = node;
            }
        }
    }

}
  class ListNode{
        Optional<ListNode> next = Optional.empty();
        Optional<ListNode> prev = Optional.empty();
        private int key;
        private int value;
        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getValue(){
            return value;
        }

        public int getKey(){
            return key;
        }
    }
