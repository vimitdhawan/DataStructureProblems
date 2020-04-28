package com.vimit.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomanNumber {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M',1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L',50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            String value = br.readLine();
            int result = getRoman(map, value);
            System.out.println(result);
        }



    }

    private static int getRoman(Map<Character, Integer> map, String value) {
        int sum =0;
        int previous=0;
        for(int i=value.length()-1; i>=0; i--){
            if(map.get(value.charAt(i))>=previous){
                sum = sum + map.get(value.charAt(i));
            } else{
                sum = sum - map.get(value.charAt(i));
            }
            previous = map.get(value.charAt(i));
        }
        return sum;
    }

}
