package com.vimit.dynamicprogramming;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSumProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String valueString  = br.readLine();
            String[] strArr = valueString.split("\\s+");
            int arr[] = new int[length];
            int sum =0;
            for (int j = 0; j < length; j++) {
                arr[j] = Integer.parseInt(strArr[j]);
                sum = sum +arr[j];
            }
            if(sum==0 || sum%2!=0){
                System.out.println("NO");
            }else{
                Boolean[][] memo = new Boolean[length][(sum/2)+1];
                boolean isSubSetEqualSum = validateSubSetEqual(arr,0,sum/2, memo);
                if(isSubSetEqualSum) System.out.println("YES"); else  System.out.println("NO");
            }
        }

    }

    private static boolean validateSubSetEqual(int[] arr, int i, int sum, Boolean[][] memo) {
        if(sum==0) return true;
        if(i>=arr.length) return false;
        if(memo[i][sum]!=null) return memo[i][sum];
        if(sum>=arr[i]){
            if(validateSubSetEqual(arr, i+1, sum-arr[i], memo)){
                memo[i][sum] = true;
                return true;
            }
        }
        memo[i][sum] = validateSubSetEqual(arr, i+1, sum, memo);
        return memo[i][sum];
    }
}
