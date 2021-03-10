package com.vimit.dynamicprogramming;

import java.lang.*;
import java.util.Scanner;

public class OptimalStrategy
{
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking total number of testcases
        int t = sc.nextInt();

        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];

            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            //calling the countMaximum() method of class solve
            System.out.println(new solve().countMaximum(arr, n));
        }
    }


}// } Driver Code Ends


class solve{
    static long countMaximum(int arr[], int n){
        int  memo[][] = new int[n][n];
        return getMaxSum(arr, memo,0,n-1);
    }
    static int getMaxSum(int arr[], int memo[][], int start, int end){
        if(start>end) return 0;
        int startSum = memo[start][end]==0 ? arr[start]+Math.max(getMaxSum(arr, memo, start+2, end), getMaxSum(arr, memo, start+1, end-1)): memo[start][end];
        int lastSum = memo[end][start]==0 ? arr[end]+Math.max(getMaxSum(arr, memo, start, end-2),getMaxSum(arr, memo, start+1, end-1)): memo[end][start];
        memo[start][end] = startSum;
        memo[end][start] = lastSum;
        return Math.max(startSum,lastSum);
    }
}