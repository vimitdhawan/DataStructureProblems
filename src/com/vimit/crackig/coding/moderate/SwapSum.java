package com.vimit.crackig.coding.moderate;

import java.util.*;

public class SwapSum {
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        long ASum = Arrays.stream(A).sum();
        long BSum = Arrays.stream(B).sum();
        if(ASum>BSum){
            long diff = ASum-BSum;
            return diff %2==0 ? checkValue(A, B, diff/2): -1;
        }else{
            long diff = BSum-ASum;
            return diff %2==0 ? checkValue(B, A, diff/2): -1;
        }
    }
    public void saveContent(long[] arr, HashSet<Long> contents){
        for(int j =0; j<arr.length; j++){
            contents.add(arr[j]);
        }
    }

    public int checkValue(long[] bigger, long[] smaller, long target){
        HashSet<Long> contents = new HashSet<>();
        saveContent(bigger, contents);
        for(int t=0; t<smaller.length; t++){
            if(contents.contains(smaller[t]+target)){
                return 1;
            }
        }
        return -1;
    }
}
