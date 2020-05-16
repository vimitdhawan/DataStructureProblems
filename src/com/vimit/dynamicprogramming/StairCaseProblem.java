package com.vimit.dynamicprogramming;

public class StairCaseProblem {
    public static void main(String[] args) {
        int noOfRows = 28;
        int[] memo = new int[noOfRows];
        long startTimeMemo = System.currentTimeMillis();
        int noOfWays = getNoOfWaysMemo(noOfRows, memo);
        long stopTimeMemo = System.currentTimeMillis();
        System.out.println("Memo no of ways " + noOfWays + " Time " + (stopTimeMemo-startTimeMemo));

        long startTimeWithoutMemo = System.currentTimeMillis();

        int result = getNoOfWaysWithoutMemo(noOfRows);
        long stopTimeWithoutMemo = System.currentTimeMillis();
        System.out.println("Without Memo no of ways " + result + " Time " + (stopTimeWithoutMemo-startTimeWithoutMemo));

    }

    private static int getNoOfWaysWithoutMemo(int noOfRows) {
        if(noOfRows<0) return 0;
        if(noOfRows==0) return 1;
        else return  getNoOfWaysWithoutMemo(noOfRows-1)+getNoOfWaysWithoutMemo(noOfRows-2)+ getNoOfWaysWithoutMemo(noOfRows-3);

    }

    private static int getNoOfWaysMemo(int noOfRows, int[] memo) {
        if(noOfRows<0) return 0;
        if(noOfRows==0){
            return 1;
        } else if(memo[noOfRows-1]!=0){
            return memo[noOfRows-1];
        }
        else {
            int totalCount = getNoOfWaysMemo(noOfRows-1, memo)+getNoOfWaysMemo(noOfRows-2, memo)+ getNoOfWaysMemo(noOfRows-3, memo);
            memo[noOfRows-1] = totalCount;
           return totalCount;
        }
    }
}
