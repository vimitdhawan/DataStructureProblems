package com.vimit.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapsackProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            int maxWeight = Integer.parseInt(br.readLine());
            String valueString  = br.readLine();
            String weightString= br.readLine();
            String[] weightArr = weightString.split("\\s+");
            String[] valueArr = valueString.split("\\s+");
            int weight[] = new int[length];
            int value[] = new int[length];
            for (int j = 0; j < length; j++) {
                weight[j] = Integer.parseInt(weightArr[j]);
                value[j] = Integer.parseInt(valueArr[j]);
            }
            int[][] memo = new int[length][maxWeight+1];

            int maxValue = getKnapsack(value, weight, maxWeight, 0, memo);
            System.out.println(maxValue);
        }

    }

    private static int getKnapsack(int[] profits, int[] weights, int capacity,  int currentIndex, int[][] memo) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this

        if(memo[currentIndex][capacity]>0) return memo[currentIndex][capacity];

        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + getKnapsack(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1, memo);

        // recursive call after excluding the element at the currentIndex
        int profit2 = getKnapsack(profits, weights, capacity, currentIndex + 1, memo);
        int maxProfit = Math.max(profit1, profit2);
        memo[currentIndex][capacity]= maxProfit;

        return maxProfit;
    }
}
