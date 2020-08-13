package com.vimit.trie.creation;

public class TrieNode {
    public boolean leaf;
    public TrieNode[] child;
    TrieNode(){
        child = new TrieNode[26];
    }
    public TrieNode next(char c){
        return child[c-'A'];
    }
}
