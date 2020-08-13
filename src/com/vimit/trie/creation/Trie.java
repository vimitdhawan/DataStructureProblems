package com.vimit.trie.creation;

public class Trie {
    final public TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public boolean query(String s){
        TrieNode current = this.root;
        for(int i =0;  i<s.length(); i++){
            if(current== null){
                return false;
            }
            current = current.next(s.charAt(i));
        }
        return current.leaf;
    }

    public void insert(String s){
        TrieNode current = this.root;
        for(int i =0; i<s.length(); i++){
            if(current.child[s.charAt(i)-'A']==null){
                current.child[s.charAt(i)-'A'] = new TrieNode();
            }
            current = current.next(s.charAt(i));
        }
        current.leaf = true;
    }

    // true if string successfully remove
    // false if string does not exist
    public boolean delete(String s){
        TrieNode current = this.root;
        for(int i =0;  i<s.length(); i++){
            if(current==null){
                return false;
            }
            current = current.next(s.charAt(i));
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


}
