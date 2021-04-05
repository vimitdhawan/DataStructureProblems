package com.vimit.crackig.coding.dp;

public class StairCaseProblem {
    public static void main(String[] args) {
        System.out.println(countWays(10));
    }

    // function to count ways to reach mth stair
    static long countWays(int m){
        return climbStairsMemo(m, new long[m+1]);
        // your code here
    }

    static long climbStairsMemo(int n , long[] memo){
        if(n<0) return 0;
        else if(n==0) return 1;
        else if(memo[n]!=0) return memo[n];
        else{
            long value =  climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo);
            memo[n] = value;
            return memo[n];
        }
    }
}


