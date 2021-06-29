package com.vimit.interview.miro;

public class App {
    public static void main(String[] args) {
        LRUCache lc = new LRUCache(2);
        lc.put(1,1);
        lc.put(2,2);
        System.out.println(lc.get(1));
        lc.put(3,3);
        System.out.println(lc.get(2));
        lc.put(4,4);
        System.out.println(lc.get(1));
        System.out.println(lc.get(3));
        System.out.println(lc.get(4));
    }
}
