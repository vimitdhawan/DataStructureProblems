package com.vimit.trie.creation;

public class ValidateTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("VIMITD");
        System.out.println(trie.query("VIMIT"));
    }
}
