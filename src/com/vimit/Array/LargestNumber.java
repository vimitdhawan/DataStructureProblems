package com.vimit.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String value  = br.readLine();
            String[] strarr = value.split(" ");
            int count = Integer.parseInt(strarr[0]);
            int number = Integer.parseInt(strarr[1]);
            int result = 0;
            while(number/10>0){
            result = result*10;
            result = result+9;
            number = number-9;
            if(result<0){
                break;
            }
            }
            if(result<0){
                System.out.println(-1);
            } else {
                result = result*10 + number;
                System.out.println(result);
            }

        }
    }
}
