package com.vimit.trie;

public class Trie {
    final TrieNode root;
    private static final int MAX_SIZE = 26;
    public Trie() {
        root = new TrieNode();
    }

    public boolean query(String s){
        TrieNode current = root;
        for(int i =0;  i<s.length(); i++){
            current = current.next(s.charAt(i));
            if(current== null){
                return false;
            }
        }
        return current.leaf;
    }

    public void insert(String s){
        TrieNode current = root;
        for(int i =0; i<s.length(); i++){
            current = current.next(s.charAt(i));
            if(current==null){
                current = new TrieNode();
            }
        }
        current.leaf = true;
    }

    // true if string successfully remove
    // false if string does not exist
    public boolean delete(String s){
        TrieNode current = root;
        for(int i =0;  i<s.length(); i++){
            current = current.next(s.charAt(i));
            if(current== null){
                return false;
            }
        }
        current.leaf = false;
        return true;
    }

    public boolean update(String old, String newString){
        if(delete(old)){
            insert(newString);
            return true;
        }
        return  false;
    }


    private  class TrieNode {
        private boolean leaf;
        private TrieNode[] child;
        TrieNode(){
            child = new TrieNode[MAX_SIZE];
        }
        public TrieNode next(char c){
            return child[c-'A'];
        }
    }


}
