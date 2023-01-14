package com.vimit.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstSetBit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            String binary = convertToBinary(number, "");
            int index = binary.length()-1;
            boolean isFound = false;
            while(index>=0){
                if(binary.charAt(index)=='1'){
                    isFound = true;
                    break;
                } else {
                    index--;
                }

            }
            if(isFound)  System.out.println(binary.length()-index); else System.out.println(0);
        }
    }

    private static String convertToBinary(int number, String output) {
        if(number <= 0) return output;
        if(number % 2 == 0) output = "0"+output ; else output = "1"+output;
        return convertToBinary(number/2, output);
    }
}
