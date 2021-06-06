package com.vimit.leetcode.random.contest;

public class IncrementInteger {
    public static void main(String[] args) {
        IncrementInteger ii = new IncrementInteger();
        ii.plusOne(new int[]{9});
    }

    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        int carry = 1;
        while(carry>0 && i>=0){
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
            if(carry == 0) break;

        }
        int[] output = new int[digits.length+1];
        if(carry>0){
            output[0] = carry;
            for(int j=1; j<output.length; j++){
                output[j]= digits[j-1];
            }
            return output;
        }
        return digits;

    }
}
