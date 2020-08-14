package com.vimit.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String value  = br.readLine();
            int maxSum  = Integer.parseInt(br.readLine());
            String[] strarr = value.split(" ");
            int arr[] = new int[length];
            for(int t=0; t<strarr.length; t++){
                arr[t] = Integer.parseInt(strarr[t]);
            }
            int memo[][] = new int[arr.length][maxSum+1];
            int count = getCoinCombination(arr, maxSum, memo, arr.length);
            System.out.println(count);

        }
    }

    private static int getCoinCombination(int[] arr, int maxSum, int[][] memo, int index) {
        if(maxSum==0)
            return 1;
        if(maxSum<0 || index<=0)
            return 0;
        if(memo[index-1][maxSum]!=0){
            return memo[index-1][maxSum];
        }
        memo[index-1][maxSum] =  getCoinCombination(arr, maxSum-arr[index-1], memo, index) + getCoinCombination(arr, maxSum, memo, index-1);
        return memo[index-1][maxSum];
    }

}
