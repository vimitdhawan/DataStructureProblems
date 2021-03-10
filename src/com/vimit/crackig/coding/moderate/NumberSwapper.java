package com.vimit.crackig.coding.moderate;

import java.util.Arrays;

public class NumberSwapper {
    public static void main(String[] args) {
        int[] arr = {-1,-1};
        swapNumber(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void swapNumber(int[] arr){
        arr[0] = arr[0]+arr[1];
        arr[1] = arr[0]- arr[1];
        arr[0] = arr[0]-arr[1];
    }
}
