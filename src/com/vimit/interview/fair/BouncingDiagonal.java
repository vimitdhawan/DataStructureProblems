package com.vimit.interview.fair;

import java.util.*;
public class BouncingDiagonal {
    public static void main(String[] args) {
        String s= "";
        BouncingDiagonal fr = new BouncingDiagonal();
        int[][] arr = new int[][]{{2,3,2},
                {0,2,5},
                {1,0,1}};
        fr.bouncingDiagonals(arr);
    }

    int[] bouncingDiagonals(int[][] matrix) {
        List<BouncingSum> bouncingSum = new ArrayList<>();
        int row = 0;
        for(int col =0; col<matrix.length; col++){
            int sum = 0;
            int temp_row = row;
            int temp_col = col;
            sum = sum + matrix[temp_row][temp_col];
            while(isValid(temp_row+1, temp_col+1, matrix.length)){
                sum = sum + matrix[temp_row+1][temp_col+1];
                temp_row++;
                temp_col++;
            }
            temp_row = row;
            temp_col = col;
            while(isValid(temp_row+1, temp_col-1, matrix.length)){
                sum = sum + matrix[temp_row+1][temp_col-1];
                temp_row++;
                temp_col--;
            }
            BouncingSum bs = new BouncingSum(sum, matrix[col][row]);
            bouncingSum.add(bs);
        }
        Collections.sort(bouncingSum);
        return  bouncingSum.stream().map(bs -> bs.value).mapToInt(Integer :: intValue).toArray();

    }

    boolean isValid(int row, int col, int n){
        return row>=0 && row<n && col>=0 && col<n;
    }

    class BouncingSum implements Comparable<BouncingSum>{
        int sum;
        int value;
        BouncingSum(int sum, int value){
            this.sum = sum;
            this.value = value;
        }
        public int compareTo(BouncingSum bs){
            if(this.sum == bs.sum){
                return this.value - bs.value;
            }
            return this.sum - bs.sum;
        }

    }

}
