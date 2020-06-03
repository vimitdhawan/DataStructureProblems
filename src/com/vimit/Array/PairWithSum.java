package com.vimit.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String detail = br.readLine();
            String[] detailArr = detail.split("\\s+");
            int sum  = Integer.parseInt(detailArr[2]);
            String data1 = br.readLine();
            String data2 = br.readLine();
            String[] strs1 = data1.split("\\s+");
            String[] strs2 = data2.split("\\s+");
            Set<Integer> set = new HashSet<>();
            for (int k = 0; k < strs2.length; k++) {
                set.add(Integer.parseInt(strs2[k]));
            }
            boolean firstElement = true;
            int[] arr = new int[strs1.length];
            for (int l = 0; l < strs1.length; l++) {
                arr[l] = Integer.parseInt(strs1[l]);

            }
            Arrays.sort(arr);
            for (int j = 0; j < strs1.length; j++) {
                int temp =arr[j];
                if(set.contains(sum-temp)){
                    if(firstElement){
                        firstElement = false;
                        System.out.print(temp+" "+(sum-temp));

                    }else System.out.print(", " + temp+" "+(sum-temp));

                }
            }
            if(firstElement) System.out.println(-1); else System.out.println();

        }
    }

}
