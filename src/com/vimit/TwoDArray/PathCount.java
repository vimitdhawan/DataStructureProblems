package com.vimit.TwoDArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String value  = br.readLine();
            String[] strarr = value.split(" ");
            int n = Integer.parseInt(strarr[0]);
            int m = Integer.parseInt(strarr[1]);
            int[][] memo = new int[n][m];
            int res  = getCount(n-1, m-1, memo);
        }
    }

    private static int getCount(int n, int m, int[][] memo) {
        if(n==0 && m==0) return 1;
        if(n<0 || m<0) return 0;
        if(memo[n][m]!=0) return memo[n][m];
        int res =  getCount(n-1, m ,memo) + getCount(n, m-1 ,memo);
        memo[n][m] = res;
        return res;
    }
}
