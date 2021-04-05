package com.vimit.crackig.coding.ArrayString;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "aab"));
    }
    public static boolean isAnagram(String a,String b)
    {

        if(a.length() != b.length()) return false;
        int[] arr = new int[26];
        for(int i =0; i<a.length(); i++){
            int index = a.charAt(i)-'a';
            arr[index] = arr[index]+1;
        }
        for(int j =0; j<b.length(); j++){
            int index = b.charAt(j)-'a';
            if( arr[index] ==0 ) return false;
            arr[index] = arr[index]-1;

        }
        return true;
        // Your code here

    }
}
