package com.vimit.aonecode.facebook;

import java.util.*;
public class MatrixDiagonally {
    public static void main(String[] args) {
        MatrixDiagonally md = new MatrixDiagonally();
        int[][] arr = new int[][]{{12, 7, 21, 31,11},{45, -2, 14, 27,19}, {-3, 15, 36, 71, 26},{4, -13, 55, 34,15}};
        System.out.println(md.sunDiagonally(arr));
    }

    public List<List<Integer>> sunDiagonally(int[][] arr){
        List<List<Integer>> sumList = new ArrayList<>();
        int colIndex = 0;
        int rowIndex = 1;
        while(colIndex<arr[0].length){
            int traverseRowIndex = 0;
            int traverseCowIndex = colIndex;
            addSum(traverseRowIndex, traverseCowIndex, sumList, arr);
            colIndex++;
        }
        while(rowIndex<arr.length){
            int traverseRowIndex = rowIndex;
            int traverseCowIndex = arr[0].length-1;
            addSum(traverseRowIndex, traverseCowIndex, sumList, arr);
            rowIndex++;
        }
        return sumList;

    }

    public void addSum(int traverseRowIndex, int traverseCowIndex, List<List<Integer>> sumList, int[][] arr ){
        List<Integer> diagonalSum = new ArrayList<>();
        while(traverseRowIndex>=0 && traverseCowIndex>=0 && traverseRowIndex<arr.length && traverseCowIndex<arr[0].length){
            diagonalSum.add(arr[traverseRowIndex][traverseCowIndex]);
            traverseRowIndex++;
            traverseCowIndex--;
        }
        sumList.add(diagonalSum);

    }
}
