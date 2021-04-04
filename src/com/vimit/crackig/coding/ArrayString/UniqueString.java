package com.vimit.crackig.coding.ArrayString;

public class UniqueString {
    public static void main(String[] args) {
        System.out.println(isUnique("abca"));
        System.out.println(isUnique("abc"));
    }

    private static Boolean isUnique(String input){
        int[] memo = new int[256];
        boolean isUniqueString = true;
        for(int i =0; i<input.length(); i++){
            if(memo[input.charAt(i)]==0){
                memo[input.charAt(i)] = 1;
            } else{
                isUniqueString = false;
                break;
            }
        }
        return isUniqueString;
    }
}
