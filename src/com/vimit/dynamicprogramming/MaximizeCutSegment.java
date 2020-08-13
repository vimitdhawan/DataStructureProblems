package com.vimit.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximizeCutSegment {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine().trim());
            String str = br.readLine();
            String[] arr = str.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            int z = Integer.parseInt(arr[2]);
            int[] memo = new int[length+1];
            boolean[] visited = new boolean[length+1];
            Arrays.fill(memo, -1);
            int count = maximizeCut(length, memo, x, y, z, visited);
            System.out.println(count);

        }
    }

    private static int maximizeCut(int length, int[] memo, int x, int y, int z,  boolean[] visited ) {
        if(length==0) return 0;
        if(length<x && length<y && length<z) return -1;
        if(memo[length]!=-1) return memo[length];
        if(visited[length]) return -1;
        int op1 = maximizeCut(length-x, memo, x,y,z, visited);
        int op2 = maximizeCut(length-y, memo, x,y,z, visited);
        int op3 = maximizeCut(length-z, memo, x,y,z, visited);
        int max = Math.max(op1, Math.max(op2,op3 ));
        if(max!=-1){
            memo[length]=max+1;
        }
        visited[length] = true;
        return memo[length];
    }
}
