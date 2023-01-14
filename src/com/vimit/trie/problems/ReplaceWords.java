package com.vimit.trie.problems;
import java.util.*;
public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
        System.out.println(rw.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insertValue(s);
        }
        String[] senArr = sentence.split(" ");
        for (int index = 0; index < senArr.length; index++) {
            String sen = senArr[index];
            senArr[index] = trie.findValue(sen);
        }
        return String.join(" ", senArr);
    }
}

class Trie {
    Node root;
    Trie(){
        this.root = new Node();
    }

    public void insertValue(String s){
        Node current = this.root;
        char[] arr = s.toCharArray();
        for(char c: arr){
            if(current.child[c-'a'] == null){
                current.child[c-'a'] = new Node();
            }
            current = current.child[c-'a'];
        }
        current.leaf = true;
    }

    public String findValue(String s){
        char[] arr = s.toCharArray();
        Node current = this.root;
        for(int index =0; index<arr.length; index++ ){
            char c = arr[index];
            if(current == null) {
                return s;
            } else if(current.child[c-'a'] != null && current.child[c-'a'].leaf){
                return s.substring(0, index+1);
            } else if(current.child[c-'a'] == null){
                return s;
            } else{
                current =  current.child[c-'a'];
            }
        }
        return s;
    }

}

class Node {
    boolean leaf;
    Node[] child;
    Node() {
        child = new Node[26];
    }
}

