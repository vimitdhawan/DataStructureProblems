package com.vimit.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            printPermutation(input, 0);

        }
    }

    private static void printPermutation(String input, int l) {
        if(l==input.length()-1) System.out.println(input);
        for(int i=l; i<input.length(); i++){
            String res = swap(input, i, l);
            printPermutation(res,l+1);
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
