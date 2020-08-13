package com.vimit.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HopNumber {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            int[] memo = new int[length+1];
            int count = getNoOfWays(length, memo);

        }
    }

    private static int getNoOfWays(int length, int[] memo) {
        if(length==0) return 1;
        if(length<0) return 0;
        if(memo[length]!=0) return memo[length];
        int count =  getNoOfWays(length-1, memo)+getNoOfWays(length-2, memo) +getNoOfWays(length-3, memo);
        memo[length] = count;
        return count;
    }

}
