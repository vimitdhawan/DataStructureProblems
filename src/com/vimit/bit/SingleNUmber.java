package com.vimit.bit;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,1]
        Output: 1
        Example 2:

        Input: [4,1,2,1,2]
        Output: 4
*/

public class SingleNUmber {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(singleNumber(arr));

    }

    public static int singleNumber(int[] nums) {
        int result =0;
        for(int i=0; i<nums.length; i++){
            result^=nums[i];
        }
        return result;

    }
}

