package com.vimit.interview.foodpanda;

// flip coin
public class FlipCoin {
    public static void main(String[] args) {
        FlipCoin m1 = new FlipCoin();
        System.out.println(m1.solution(new int[]{1,1,0,1,1}));

    }

    public int solution(int[] A) {
        if(A.length <= 1) return 0;
        int[] memo = new int[A.length];
        int[] memo1 = new int[A.length];
        int previousValue = A[0] == 0 ? 1 : 0;
        return Math.min(flipCoins(0, previousValue, A, memo), flipCoins(0, A[0], A, memo1));
    }

    public int flipCoins(int currentIndex, int previousValue, int[] A, int[] memo){
        if(currentIndex == A.length) return 0;
        if(memo[currentIndex]!= 0) return memo[currentIndex];
        int count = 0;
        if(A[currentIndex] == previousValue){
            int flipValue = A[currentIndex] == 1 ? 0 : 1;
            count = 1 + flipCoins(currentIndex+1, flipValue, A, memo);
        }else{
            count = flipCoins(currentIndex+1, A[currentIndex], A, memo);
        }
        memo[currentIndex] = count;
        return  memo[currentIndex];
    }
}
