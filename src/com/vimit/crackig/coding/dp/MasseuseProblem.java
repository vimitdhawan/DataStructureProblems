package com.vimit.crackig.coding.dp;

public class MasseuseProblem {
    public static void main(String[] args) {
        int[] arr = {30, 15, 60, 75, 45, 15, 15, 45};
        int[] memo = new int[arr.length];
        System.out.println(getOptimalTime(arr, 0, memo));
    }

    public static int getOptimalTime(int[] arr, int index, int[] memo) {
        if(index>=arr.length) return 0;
        if(memo[index]==0){
            int sum1 = getOptimalTime(arr, index+2, memo)+arr[index];
            int sum2 = getOptimalTime(arr, index+1, memo);
            memo[index] = Math.max(sum1, sum2);
        }
        return memo[index];

    }

}
