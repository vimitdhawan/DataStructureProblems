package com.vimit.crackig.coding.dp;

import java.util.*;

// sample input
// 1 <- tets cases
// 10 <- arr length
// -10 -1 0 3 10 11 30 50 100 150 <- array values

class MagicNumber
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG gfg = new GfG();
            System.out.println(gfg.binarySearch(arr, 0, n-1));
        }
    }
}
// } Driver Code Ends


class GfG
{
    public static int binarySearch(int arr[], int low, int high)
    {
        if(low>high) return -1;
        int middle = low + (high-low)/2;
        if(arr[middle] == middle) return middle;
        else if(arr[middle] > middle) return binarySearch(arr, low, middle-1);
        else return binarySearch(arr, middle+1, high);

    }
}

