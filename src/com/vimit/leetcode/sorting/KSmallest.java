package com.vimit.leetcode.sorting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.*;

public class KSmallest {
    public static void main(String[] args) throws ParseException {
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int length = matrix.length;
        int i = 0;
        int result = 0;
        while(i<length && k>0){
            for(int j=0; j<length; j++){
                pq.add(matrix[i][j]);
            }
            while(!pq.isEmpty() && k>0){
                result = pq.poll();
                k--;
            }
            i++;
        }
        return result;

    }
}
