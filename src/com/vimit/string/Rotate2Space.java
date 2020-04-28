package com.vimit.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rotate2Space {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            if(getSimilarity(s1, s2)==1 || getSimilarity(s2, s1)==1){
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

    private static int getSimilarity(String s1, String s2) {
        String s1SecondHalf = s1.substring(2, s1.length());
        String s1FirstHalf = s1.substring(0, 2);

        String s2FirstHalf = s2.substring(0, s2.length() - 2);
        String s2SecondHalf = s2.substring(s2.length() - 2, s2.length());

        if (s1SecondHalf.equals(s2FirstHalf) && s1FirstHalf.equals(s2SecondHalf)) {
            return 1;
        } else {
            return 0;
        }
    }
}
