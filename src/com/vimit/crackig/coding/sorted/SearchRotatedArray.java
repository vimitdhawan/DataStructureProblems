package com.vimit.crackig.coding.sorted;


//Initial Template for Java
// 1 <- test cases
// 9 <- arr length
// 5 6 7 8 9 10 1 2 3 <- array
// 10 <- output array

import java.util.*;

public class SearchRotatedArray{
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++)
            {
                array[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            RotatedSolution ob = new RotatedSolution();
            System.out.println(ob.Search(array,target));
            t--;
        }
    }
} // } Driver Code Ends


//User function Template for Java

class RotatedSolution
{
    static int Search(int array[], int target)
    {
        return searchElement(0, array.length-1, array, target);
    }

    static int searchElement(int start, int end, int[] array, int target){
        if(start>end) return -1;
        int middle = start + (end-start)/2;
        if(array[middle] == target) return middle;
        if(array[start] < array[middle]){
            if(target>=array[start] && target<array[middle]){
                return searchElement(start, middle-1, array, target);
            } else {
                return searchElement(middle+1, end, array, target);
            }
        } else{
            if(target>array[middle] && target<=array[end]){
                return searchElement(middle+1, end, array, target);

            } else {
                return searchElement(start, middle-1, array, target);
            }
        }

    }
}

