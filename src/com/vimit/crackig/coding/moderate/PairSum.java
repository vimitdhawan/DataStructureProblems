package com.vimit.crackig.coding.moderate;
import java.util.*;
public class PairSum {
    public static void main(String[] args) {
        int count = getPairsCount(new int[]{5,6,5},3, 11);
        System.out.println(count);
    }
    static int getPairsCount(int[] arr, int n, int k) {
        int count =0;
        Map<Integer, Integer> compliments = new HashMap<>();
        for(int i=0; i<n; i++){
            int compliment = k-arr[i];
            if(compliments.containsKey(compliment)){
                count = count + compliments.get(compliment);
            }
            if(compliments.containsKey(arr[i])){
                compliments.put(arr[i], compliments.get(arr[i])+1);
            } else{
                compliments.put(arr[i],1);
            }
        }
        return count;
    }
}
