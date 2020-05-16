package com.vimit.dynamicprogramming;

public class RecursionUnderstanding {
    public static void main(String[] args) {

        runFirstRecursionOnly(3, 5);

        System.out.println("-----------------------------------------------");

        runBothReccursion(3, 5);

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
}
