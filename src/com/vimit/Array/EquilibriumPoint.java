package com.vimit.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// it is a point where right side element is equal to left side [1 3 5 2 2] // 5 is equilibrium point
public class EquilibriumPoint {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String data = br.readLine();
            String[] strs = data.split("\\s+");
            int arr[] = new int[strs.length];
            int sum=0;
            for (int j = 0; j < strs.length; j++) {
                arr[j] = Integer.parseInt(strs[j]);
                sum = sum + arr[j];
            }

            int leftSum=0;
            int index =0;
            for(int k =0; k<arr.length; k++){
                sum = sum-arr[k];
                if(sum==leftSum){
                    index = k+1;
                    break;
                }
                leftSum = leftSum + arr[k];
            }

            if(index!=0){
                System.out.println(index);
            } else{
                System.out.println(-1);
            }

        }

    }
}
