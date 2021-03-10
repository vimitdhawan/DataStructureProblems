package com.vimit.string;


// Initial Template for Java

import java.io.*;
        import java.util.*;

public class LongestKUnique {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            SolutionLongestKUnique obj = new SolutionLongestKUnique();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class SolutionLongestKUnique {
    public int longestkSubstr(String s, int k) {
        int[] memo = new int[26];
        Arrays.fill(memo, -1);
        int max =-1;
        int current = 0;
        int prevIndex= s.charAt(0)-'a';
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            if(memo[index]==-1){
                if(k>0){
                    k--;
                    current = current+1;
                } else {
                    current = current - memo[prevIndex];
                    prevIndex = getIndex(memo[prevIndex]+1, memo);
                }

            } else{
                current = current+1;
            }
            memo[index] =i;
            if(current>max){
                max = current;
            }
        }
        if(k>=0) return max;
        else return -1;
    }

    public int getIndex(int index, int[] memo){
        for(int j=0; j<26; j++){
            if(memo[j] == index) return j;
        }
        return 0;
    }
}
