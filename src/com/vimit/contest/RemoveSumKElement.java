package com.vimit.contest;

import java.util.*;
public class RemoveSumKElement {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            int requiredElement = k - nums[i];
            if(map.containsKey(requiredElement)){
                if(map.get(requiredElement)>0){
                    count++;
                }
            }
            map.put(requiredElement, map.getOrDefault(requiredElement,2)-1);

        }
        return count;
    }


}
