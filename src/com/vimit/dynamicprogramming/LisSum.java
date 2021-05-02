package com.vimit.dynamicprogramming;

import java.util.*;
public class LisSum
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int Arr[] = new int[n];
            for(int i = 0;i<n;i++)
                Arr[i] = sc.nextInt();
            LISSolution ob = new LISSolution();
            System.out.println(ob.maxSumIS(Arr,n));
        }
    }
}    // } Driver Code Ends


//User function Template for Java

class LISSolution
{
    public int maxSumIS(int arr[], int n)
    {
        int memo[] = arr.clone();
        int i =0;
           /* Compute optimized LIS values in
              bottom up manner */
        for ( i = 1; i < n; i++ ){
            int tempSum = memo[i];
            for ( int j = 0; j < i; j++ ){
                if ( arr[i] > arr[j] && tempSum < (memo[j] + memo[i])){
                    tempSum = memo[j] +  memo[i];
                }
            }
            memo[i] = tempSum;

        }

        int max = 0;
        /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < memo[i] )
                max = memo[i];

        return max;
    }
}