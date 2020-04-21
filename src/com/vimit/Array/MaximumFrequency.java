package com.vimit.Array;

import java.util.HashMap;
import java.util.Map;

public class MaximumFrequency {

    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int maxNumber = getMaxFrequemcyNumber(arr);
    }

    private static int getMaxFrequemcyNumber(int[] arr) {
        int maxCount = -1;
        Integer maxItem = null;

        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (dict.containsKey(arr[i])) {
                dict.put(arr[i], dict.get(arr[i]) + 1);
            } else {
                dict.put(arr[i], 1);
            }
            if (maxCount < dict.get(arr[i])) {
                maxCount = dict.get(arr[i]);
                maxItem = arr[i];
            }
        }

        return  maxItem;
    }
}
