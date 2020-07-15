package com.vimit.dynamicprogramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountEdit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String lengths = br.readLine();
            String bothValue  = br.readLine();
            String[] arr = bothValue.split(" ");
            String value1 = arr[0];
            String value2 = arr[1];
            int[][] memo = new int[value1.length()][value2.length()];
            int editCount = getEditCount(value1, value2, value1.length(), value2.length(), memo);
            System.out.println(editCount);
        }

    }

    private static int getEditCount(String value1, String value2, int i , int j, int[][] memo ) {
        if(i==0) return j;
        if(j==0) return i;
        if(memo[i-1][j-1]!=0) return memo[i-1][j-1];

        if(value1.charAt(i-1) == value2.charAt(j-1)){
           return getEditCount(value1, value2, i-1, j-1, memo);
        }
        int count = 1 + min(getEditCount(value1, value2, i-1, j, memo), getEditCount(value1, value2, i, j-1, memo), getEditCount(value1, value2, i-1, j-1, memo));
        memo[i-1][j-1] = count;
        return count;
    }

    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }
}
