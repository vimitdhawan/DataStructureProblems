package com.vimit.leetcode.contest;

import java.util.*;
public class ReductionOperation {

    public static void main(String[] args) {
        ReductionOperation ro = new ReductionOperation();
        int[] arr = new int[] {5,1,3};
        System.out.println(ro.reductionOperations(arr));
    }

    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        int i =0;
        for(i =0; i<nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0)+1);
        }
        int swapCount = 0;
        Map.Entry<Integer, Integer>  current = counter.pollLastEntry();
        while(!counter.isEmpty()){
            swapCount = swapCount + current.getValue() * counter.size();
            current = counter.pollLastEntry();

        }
        return swapCount;
    }

}
