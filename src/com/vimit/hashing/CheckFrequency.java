package com.vimit.hashing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckFrequency {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input[] = read.readLine().split(" ");
            String a = input[0];
            if (sameFreq(a)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
         static boolean sameFreq(String s) {
            int[] arr = new int[26];
            for(int i=0; i<s.length(); i++){
                int index = s.charAt(i)-'a';
                arr[index] = arr[index]+1;
            }

            if(isSame(arr)) return true;
            else{
                for(int a=0; a<26; a++){
                    if(arr[a]>0){
                        arr[a]--;
                        if(isSame(arr)) return true;
                        else arr[a]++;
                    }
                }
            }

            return false;
        }

         static boolean isSame(int[] arr){
            int t;
            int value=0;
            for(t=0; t<arr.length; t++){
                if(arr[t]>0){
                    value = arr[t];
                    break;
                }
            }

            for(int p=t; p<arr.length; p++){
                if(arr[p]>0 && arr[p]!=value) return false;
            }

            return true;
        }

}
