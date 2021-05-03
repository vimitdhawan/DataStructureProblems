package com.vimit.crackig.coding.moderate;

import java.util.*;

public class SmallestDifference {
    public static void main(String[] args) {
       int diff =  smallestDifferencePair(Arrays.asList(1,2,3,4,6, 7), 6, Arrays.asList(6,7,8,9,10) ,5);
       System.out.println(diff);
    }

    public static int smallestDifferencePair(List<Integer> arr1, int n, List<Integer> arr2, int m) {
        Collections.sort(arr1);
        Collections.sort(arr2);
        int i =0;
        int j =0;
        int min = Integer.MAX_VALUE;
        while(i<n && j<m){
            int firstValue = arr1.get(i);
            int secondValue = arr2.get(j);
            int diff = Math.abs(firstValue-secondValue);
            if(diff < min){
                min = diff;
            }
            if(firstValue<secondValue){
                i++;
            } else if(secondValue<firstValue){
                j++;
            }else{
                return min;
            }
        }
        return min;
    }
}
