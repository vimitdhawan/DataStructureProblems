package com.vimit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxToys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int maxSum = Integer.parseInt(br.readLine().split(" ")[1]);
            String data1 = br.readLine();
            String[] strs1 = data1.split("\\s+");
            int[] arr = new int[strs1.length];
            for (int k = 0; k < arr.length; k++) {
                arr[k] = Integer.parseInt(strs1[k]);
            }
            Arrays.sort(arr);
            int count =0;
            for(int p=0; p<arr.length; p++){
                if(arr[p]>maxSum) break;
                maxSum -= arr[p];
                count++;
            }
            System.out.println(count);

        }

    }
}
