package com.vimit.aonecode;

public class MinimumSubArrSum {
    public static void main(String[] args) {

    }

    //[2,3,1,2,4,3]

    public int minSubArrayLen(int target, int[] nums) {
        int startIndex = 0;
        int lastIndex = 0;
        int currentSum = nums[0];
        int min = Integer.MAX_VALUE;
        while(lastIndex<nums.length-1){
            if(currentSum<target){
                lastIndex++;
                currentSum += nums[lastIndex];
            }

            while(currentSum>=target && startIndex<nums.length){
                min = Math.min(min, lastIndex-startIndex);
                currentSum -= nums[startIndex];
                startIndex++;
            }
        }

        if(min == Integer.MAX_VALUE) return 0;
        return min+1;

    }
}
