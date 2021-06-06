package com.vimit.leetcode.dp;

public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString il = new InterleavingString();
        System.out.println(il.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        else{
            BooleanWrapper bool = new BooleanWrapper();
            int[][] memo = new int[s1.length()+1][s2.length()+1];
            traverse(0,0,s1,s2,s3,0, memo, bool);
            return bool.isFound;
        }
    }

    public void traverse( int s1Index, int s2Index, String s1, String s2, String s3, int index, int[][] memo, BooleanWrapper bool){
        if(index == s3.length()){
            bool.isFound = true;
            return;
        }
        if(memo[s1Index][s2Index]==1) return;
        if(s1Index<s1.length() && !bool.isFound && s1.charAt(s1Index) == s3.charAt(index)){
            traverse(s1Index+1, s2Index, s1, s2, s3, index+1, memo, bool);
        }
        if(s2Index<s2.length() && !bool.isFound && s2.charAt(s2Index) == s3.charAt(index)){
             traverse( s1Index, s2Index+1, s1, s2, s3, index+1, memo, bool);
        }
        memo[s1Index][s2Index]=1;
    }

    private class BooleanWrapper{
        boolean isFound = false;
    }
}
