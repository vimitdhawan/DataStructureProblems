package com.vimit.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class SubSetProblem {
    public static void main(String[] args) {
        SubSetProblem sp = new SubSetProblem();
        List<List<Integer>> resp = sp.subsets(new int[]{});
        System.out.println(resp.size());
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> set = new ArrayList<>();
        set.add(subSet);
        traverseList(0, set, nums);
        return set;
    }

    public void traverseList(int index, List<List<Integer>> set, int[] nums){
        if(index == nums.length) return;
        int size = set.size();
        int j = 0;
        while(j<size){
            List<Integer> cloned_list = new ArrayList<>(set.get(j));
            cloned_list.add(nums[index]);
            j++;
            set.add(cloned_list);
        }
        traverseList(index+1, set, nums);
    }

}
