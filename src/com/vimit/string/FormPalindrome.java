package com.vimit.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FormPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            Map<Character, Integer> map = new HashMap<>();

            for(int t=0; t<input.length(); t++){
                if(map.containsKey(input.charAt(t))){
                    map.put(input.charAt(t), map.get(input.charAt(t))+1);
                } else {
                    map.put(input.charAt(t),1);
                }
            }
           long result =  map.values().stream().filter(a -> a%2!=0).count();
            System.out.println(result-1);
        }

    }
}
