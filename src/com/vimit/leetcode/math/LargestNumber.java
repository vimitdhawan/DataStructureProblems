package com.vimit.leetcode.math;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> stringNums = Arrays.stream(nums).mapToObj(i -> String.valueOf(i)).collect(Collectors.toList());
        Collections.sort(stringNums, (a, b) -> (b+a).compareTo(a+b));
        StringBuilder res = new StringBuilder();
        for(String num : stringNums){
            res.append(num);
        }

        return res.toString();

    }
}
