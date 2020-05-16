package com.vimit.crackig.coding.moderate;

public class FactorialZero {
    public static void main(String[] args) {
        int num = 10;
        int count = getFactorialZero(num);
        int factorial = getFactorial(num);
        System.out.println(factorial);
        System.out.println(count);
    }

    private static int getFactorial(int num) {
        if(num==1){
            return 1;
        } else{
            return num * getFactorial(num-1);
        }
    }

    private static int getFactorialZero(int i) {
        int count =0;
        for(int num=5; (i/num)>0; num = num*5) {
            count = count + (i/num);
        }
        return count;
    }
}
