package com.vimit.leetcode.dp;


public class BestTimeBuySell {
    public static void main(String[] args) {
        BestTimeBuySell bs = new BestTimeBuySell();
        System.out.print(bs.maxProfit(new int[]{1,2,3,0,2}));
    }
    public int maxProfit(int[] prices) {
        Integer[][] memo=new Integer[prices.length][2];
        return f(prices,0,0,memo);
    }

    public int f(int[] arr,int i,int counter,Integer[][] memo)
    {
        if(i>=arr.length)
            return 0;
        if(memo[i][counter]!=null)
            return memo[i][counter];
        int x= 0;
        if(counter == 0)
            x=f(arr,i+1,1,memo)-arr[i];
        else if(counter == 1)
            x=f(arr,i+2,0,memo)+arr[i];
        return memo[i][counter] = Math.max(f(arr,i+1,counter,memo),x);
    }
}
