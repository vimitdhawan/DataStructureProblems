package com.vimit.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            int memo[] = new int[maxSum+1];
            int count = getCoinCombination(arr, maxSum, memo);
            System.out.println(count);

        }
    }

    private static int getCoinCombination(int[] arr, int maxSum, int[] memo) {
        if(maxSum==0){
            return 1;
        } else if(maxSum<0){
            return 0;
        } else if(memo[maxSum]!=0){
            return memo[maxSum];
        } else{
            for(int i=0; i<arr.length; i++) {
            memo[maxSum] = memo[maxSum] + getCoinCombination(arr, maxSum-arr[i], memo);
            }
            return memo[maxSum];
        }
    }
}
