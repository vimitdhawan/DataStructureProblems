package com.vimit.trie.creation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateTrie {
    public static void main(String[] args) {
        List<Integer> output = new ArrayList<>();
        output.add(2);
        System.out.println(output.stream().anyMatch(t -> t == 2));
        Trie trie = new Trie();
        trie.insert("VIMITD");
        System.out.println(trie.query("VIMIT"));
    }
}
