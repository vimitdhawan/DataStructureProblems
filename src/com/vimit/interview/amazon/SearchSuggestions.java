package com.vimit.interview.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class SearchSuggestions {

    public static void main(String[] args) {
        List<String> codeList = Arrays.asList("code", "codePhone", "coddle", "coddles", "codes");
        List<String> codes = codeList.stream().flatMap(value -> Arrays.asList(value.split(" ")).stream()).collect(Collectors.toList());
        List<String> repo = Arrays.asList("code", "codePhone", "coddle", "coddles", "codes");
        searchSuggestions(repo, "coddle");
    }
        /*
         * Complete the 'searchSuggestions' function below.
         *
         * The function is expected to return a 2D_STRING_ARRAY.
         * The function accepts following parameters:
         *  1. STRING_ARRAY repository
         *  2. STRING customerQuery
         */

        public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
            List<List<String>> suggestions = new ArrayList<>();
            if(customerQuery.length()<2) return suggestions;
            TrieNode root = createTrie(repository);
            for(int i =2; i<=customerQuery.length(); i++){
                List<String> suggestedWords = fetchAll(customerQuery.substring(0, i).toLowerCase(), root);
                suggestions.add(suggestedWords.stream().limit(3).collect(Collectors.toList()));
            }
            return suggestions;
        }

        public static TrieNode createTrie(List<String> repository){
            TrieNode root = new TrieNode();
            for(String word: repository){
                TrieNode current = root;
                char[] arr = word.toLowerCase().toCharArray();
                for(char character: arr){
                    int index = character - 'a';
                    if(current.childNodes[index]==null){
                        current.childNodes[index] = new TrieNode();
                    }
                    current = current.childNodes[index];
                }
                current.word = word;
            }
            return root;
        }

        public static List<String> fetchAll(String word, TrieNode root){
            List<String> result = new ArrayList<>();
            TrieNode current = root;
            for(char character: word.toCharArray()){
                int index = character - 'a';
                if(current.childNodes[index] != null){
                    current = current.childNodes[index];
                    if(!current.word.isEmpty()) result.add(current.word);
                }else{
                    return result;
                }
            }
            traverse(current, result);
            return result;
        }

        public static void traverse(TrieNode current, List<String> result){
            for(int i= 0; i<26; i++){
                if(current.childNodes[i]!=null){
                    if(!current.childNodes[i].word.isEmpty()) result.add(current.childNodes[i].word);
                    traverse(current.childNodes[i], result);
                }
            }
        }


    }

    class TrieNode{
        TrieNode[] childNodes = new TrieNode[26];
        String word = "";
    }


