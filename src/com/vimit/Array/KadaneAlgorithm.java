package com.vimit.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KadaneAlgorithm {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length  = Integer.parseInt(br.readLine());
            String data1 = br.readLine();
            String[] strs1 = data1.split("\\s+");
            int[] arr = new int[strs1.length];
            for (int k = 0; k < length; k++) {
                arr[k] = Integer.parseInt(strs1[k]);
            }
            int maxSum = arr[0];
            int currentSum = arr[0];
            for(int j=1; j<arr.length; j++){
                currentSum = arr[j] + currentSum;
                if(arr[j]>currentSum){
                    currentSum = arr[j];
                }
                if(currentSum>maxSum){
                    maxSum = currentSum;
                }

            }

            System.out.println(maxSum);

        }
    }
}
