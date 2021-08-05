package com.vimit.leetcode.backtracking;

import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> result = pp.partition("aab");
        System.out.println(result);
    }
    public List<List<String>> partition(String s) {
        List<List<String>> finalResult = new ArrayList<>();
        List<String> result = new ArrayList<>();
        findPalindrome(0, s, finalResult, result);
        return finalResult;
    }

    public void findPalindrome(int startIndex, String s, List<List<String>> finalResult, List<String> result){
        if(startIndex == s.length()){
            List<String> cloned_list= new ArrayList<String>(result);
            finalResult.add(cloned_list);
            return;
        }
        for(int i = startIndex; i<s.length(); i++){
            String temp = s.substring(startIndex, i+1);
            if(isPalindrome(temp)){
                result.add(temp);
                findPalindrome(i+1, s, finalResult, result);
                result.remove(result.size()-1);
            }
        }

    }



    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
