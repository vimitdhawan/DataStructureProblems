package com.vimit.string;

import java.util.*;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(nonRepeating("abcab")); // should return 'c'
        nonRepeating("abab"); // should return null
        nonRepeating("aabbbc"); // should return 'c'
        nonRepeating("aabbdbc"); // should return 'd'
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        char arr[] = s.toCharArray();
        Character nonRepeating = null;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            } else{
                map.put(arr[i],1);

            }
        }
        for(int j=0; j<arr.length; j++){
            if(map.get(arr[j])==1){
                nonRepeating = arr[j];
                break;
            }
        }
        return nonRepeating;
    }
}
