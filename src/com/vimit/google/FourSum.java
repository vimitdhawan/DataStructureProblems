package com.vimit.google;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        FourSum fs = new FourSum();
        List<List<Integer>> res = fs.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},       -294967296);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i =0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int start = j+1;
                int end = nums.length-1;
                long curentTarget = target - (nums[i] + nums[j]);
                if(curentTarget<=Integer.MAX_VALUE && curentTarget>=Integer.MIN_VALUE)              {
                    while(start<end){
                        List<Integer> result = new ArrayList<>();
                        if(curentTarget == nums[start] + nums[end]){
                            long maxCheck = (long)nums[i] + (long)nums[j] + (long)nums[start] + (long)nums[end];
                            if(maxCheck<=Integer.MAX_VALUE && maxCheck>=Integer.MIN_VALUE){
                                result.addAll(Arrays.asList(nums[i], nums[j],nums[start],nums[end]));
                                Collections.sort(result);
                                set.add(result);
                            }

                            start++;
                            end--;
                        } else if(curentTarget>(nums[start] + nums[end])){
                            start++;
                        }else{
                            end--;
                        }
                    }
                }
            }
        }
        return set.stream().collect(Collectors.toList());
    }


}
