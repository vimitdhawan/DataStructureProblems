package com.vimit.leetcode;

import java.util.Arrays;

public class RemoveDuplicateInPlace {
    public static void main(String[] args) {
        int[] num = {0,0,1,1,2};
        removeDuplicates(num);
        System.out.println(Arrays.toString(num));
    }

    public static int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]!=nums[i+1]){
                uniqueIndex++;
                for(int k =uniqueIndex; k<i+1; k++){
                    nums[k]= nums[i+1];
                }
            }

        }
        return uniqueIndex+1;

    }
}
