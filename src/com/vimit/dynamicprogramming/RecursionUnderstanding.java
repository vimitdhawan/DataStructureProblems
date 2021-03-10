package com.vimit.dynamicprogramming;

public class RecursionUnderstanding {
    public static void main(String[] args) {

       // runFirstRecursionOnly(3, 5);

        System.out.println("-----------------------------------------------");

       //  runBothReccursion(3, 5);

        System.out.println("-----------------------------------------------");

        int[][] memo = new int[3][5];
         maxRecursionWithMemo(3,5, memo);

        System.out.println("-----------------------------------------------");

      //  maxRecursion(3, 5);

        int[] sumMemo = new int[5];
      //   sumRecursion(5,sumMemo);


    }

    private static boolean runBothReccursion(int i, int j) {
        if(i==0 || j==0) return true;
        else{
            boolean result =  runBothReccursion(i-1, j) && runBothReccursion(i, j-1);
            System.out.println(i + " " + j);
            return result;
        }
    }

    private static boolean runFirstRecursionOnly(int i, int j) {
        if(i==0 || j==0) return true;
        else{
            boolean result =  runFirstRecursionOnly(i-1, j) || runFirstRecursionOnly(i, j-1);
            System.out.println(i + " " + j);
            return result;
        }
    }

    private static int maxRecursion(int i, int j) {
        if(i==0 || j==0) return 1;
        else{
            int result =  1 + Math.max(maxRecursion(i-1, j), maxRecursion(i, j-1));
            System.out.println(i + " " + j + " " + result);
            return result;
        }
    }


    private static int maxRecursionWithMemo(int i, int j, int[][] memo) {
        if(i==0 || j==0) return 1;
        else{
            if(memo[i-1][j-1]!=0) return memo[i-1][j-1];
            int result =  1 + Math.max(maxRecursionWithMemo(i-1, j, memo), maxRecursionWithMemo(i, j-1, memo));
            System.out.println(i + " " + j + " " + result);
            memo[i-1][j-1] = result;
            return result;
        }
    }


    private static int sumRecursion(int i, int[] memo) {
        if(i<=0) return 1;
        else{
            if(memo[i-1]!=0) return memo[i-1];
            int result =  sumRecursion(i-1, memo) + sumRecursion(i-2,memo);
            System.out.println(i + " " + result);
            memo[i-1] = result;
            return result;
        }
    }

}
