package com.vimit.string;

import java.io.*;
import java.util.*;

//Initial Template for Java

public class LongestCommonPrefixArray
{
    public static void main(String args[])throws IOException
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> a));
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution{
    String longestCommonPrefix(String arr[], int n){
        String res = "";
        boolean isFlag = true;
        int i=0;
        while(isFlag){
            if(i>=arr[0].length()){
                isFlag = false;
                break;
            }
            res = res+String.valueOf(arr[0].charAt(i));
            for(int k =1; k<arr.length; k++){
                String value = arr[k];
                if(i>=value.length() || value.charAt(i)!=res.charAt(i)){
                    isFlag = false;
                    break;
                }
            }
            if(!isFlag){
                break;
            }

            i++;
        }

        if(i==0){
            return "-1";
        }else{
            return res.substring(0,i);
        }


    }
}
