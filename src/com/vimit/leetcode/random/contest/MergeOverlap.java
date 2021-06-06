package com.vimit.leetcode.random.contest;

import java.util.*;
public class MergeOverlap {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int traverseMaxEnd = Math.max(intervals[i][1], currentEnd);
            if(currentEnd>=intervals[i][0] && currentEnd<=traverseMaxEnd){
                currentStart = Math.min(currentStart, intervals[i][0]);
                currentEnd = traverseMaxEnd;
            }else{
                addData(currentStart, currentEnd, result);
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }

        }
        addData(currentStart, currentEnd, result);
        int[][] resp = new int[result.size()][2];
        for(int t =0; t<result.size(); t++){
            List<Integer> temp = result.get(t);
            resp[t][0] = temp.get(0);
            resp[t][1] = temp.get(1);
        }
        return resp;


    }

    private void addData(int start, int end, List<List<Integer>> result){
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        result.add(list);
    }
}
