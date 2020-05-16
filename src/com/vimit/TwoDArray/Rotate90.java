package com.vimit.TwoDArray;

import java.util.Arrays;

public class Rotate90 {
    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        int[][] result = get90Shift(arr);
        
        System.out.println(Arrays.deepToString(arr));

    }

    private static int[][] get90Shift(int[][] arr) {

        int rowStart = 0;
        int rowEnd = arr.length-1;
        int colEnd = arr[0].length;

        while(rowStart<rowEnd){
            for(int j=0; j<colEnd; j++){
                arr = swap(arr, rowStart,rowEnd, j);
            }
            rowStart++;
            rowEnd--;
        }

        for(int i=0; i<arr.length; i++){
            int j =i;
            while(j<arr[0].length){
               int temp = arr[i][j];
               arr[i][j]= arr[j][i];
               arr[j][i] = temp;
               j++;
            }
        }

        return arr;
    }

    private static int[][] swap(int[][] arr, int rowStart, int rowEnd, int j) {
        int temp = arr[rowStart][j];
        arr[rowStart][j] = arr[rowEnd][j];
        arr[rowEnd][j] = temp;
        return arr;
    }

}
