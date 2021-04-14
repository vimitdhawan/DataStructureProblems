package com.vimit.crackig.coding.dp;
import java.io.*;
import java.util.*;
public class CoinChange
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for(int i = 0;i<m;i++)
                Arr[i] = sc.nextInt();
            CoinChange ob = new CoinChange();
            System.out.println(ob.count(Arr,m,n));
        }
    }

    public long count(int S[], int m, int n)
    {
        long[][] memo = new long[m][n+1];
        return getCoinChange(S, n, memo, m);
    }

    public long getCoinChange(int arr[], int maxSum, long[][] memo, int index){
        if(maxSum==0)
            return 1;
        if(maxSum<0 || index<=0)
            return 0;
        if(memo[index-1][maxSum]!=0){
            return memo[index-1][maxSum];
        }
        memo[index-1][maxSum] =  getCoinChange(arr, maxSum-arr[index-1], memo, index) + getCoinChange(arr, maxSum, memo, index-1);
        return memo[index-1][maxSum];

    }
}    // } Driver Code Ends


//User function Template for Java
