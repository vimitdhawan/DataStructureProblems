package com.vimit.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumNumberCoin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        int currency[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        for (int i = 0; i < testCase; i++) {
            int sum = Integer.parseInt(br.readLine());
             Memo[] memo = new Memo[sum+1];
            int count = getMinimum(sum, currency, memo);
            List<Integer> result = new ArrayList<>();
            int index = sum;
            while(memo[index]!=null){
                Memo temp = memo[index];
                result.add(temp.currencyUsed);
                index = temp.previousIndexUsed;
            }
           result.stream().sorted(new Comparator<Integer>() {
               @Override
               public int compare(Integer o1, Integer o2) {
                  return o2.compareTo(o1);
               }
           }).forEach(p -> System.out.print(p + " "));
            System.out.println();


        }

    }

    private static int getMinimum(int sum, int[] currency, Memo[] memo) {
        if (sum == 0) {
            return 0;
        }
        if(memo[sum]!=null){
            return memo[sum].count;
        }
        int res = Integer.MAX_VALUE;
        if(sum>0){
            for(int i =0; i<currency.length; i++){
                if(currency[i]<=sum){
                    int sub_res = getMinimum(sum-currency[i], currency,memo);
                    if(sub_res+1<res){
                        res = sub_res+1;
                        memo[sum] = new Memo(currency[i],sum-currency[i],  res);
                    }
                }

            }
        }
        return res;
    }
    static class Memo{
        int currencyUsed;
        int previousIndexUsed;
        int count;
        Memo(int a, int b, int c) {
            this.currencyUsed =a;
            this.previousIndexUsed =b;
            this.count =c;
        }

        @Override
        public String toString() {
            return "Memo{" +
                    "currencyUsed=" + currencyUsed +
                    ", previousIndexUsed=" + previousIndexUsed +
                    '}';
        }
    }
}

