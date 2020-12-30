package com.vimit.leetcode;

/*Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

        The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

        You may assume the integer does not contain any leading zero, except the number 0 itself.

        Example 1:

        Input: [1,2,3]
        Output: [1,2,4]
        Explanation: The array represents the integer 123.
        Example 2:

        Input: [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.*/

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] num = {1,2,3};

        System.out.println(Arrays.toString(plusOne(num)));

    }

    public static int[] plusOne(int[] digits) {

        int index = digits.length-1;

        while(index>=0){
            if(digits[index]==9){
                digits[index]=0;
                index--;
            } else{
                digits[index]=digits[index]+1;
                break;
            }

        }
        if(digits[0]==0){
            int[] results = new int[digits.length+1];
            results[0]=1;
            return results;
        }

        return digits;

    }
}
