package com.vimit.leetcode.Array;

import java.util.*;
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> memo = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for(int i =0; i<nums1.length; i++){
            if(memo.containsKey(nums1[i])){
                memo.put(nums1[i], memo.get(nums1[i])+1);
            }else{
                memo.put(nums1[i], 1);
            }

        }
        for(int j=0; j<nums2.length; j++){
            if(memo.containsKey(nums2[j]) && memo.get(nums2[j])>0){
                output.add(nums2[j]);
                memo.put(nums2[j], memo.get(nums2[j])-1);
            }
        }
        return output.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
