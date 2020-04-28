package com.vimit.TwoDArray;

import java.util.Arrays;

public class MineSweeperEasy {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
       System.out.println(Arrays.deepToString(mineSweeper(bombs1, 3, 3))); // should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

    // Implement your solution below.
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
        for(int rows = 0; rows<bombs.length; rows++){
            int i = bombs[rows][0];
            int j = bombs[rows][1];
            field[i][j] =-1;
            for(int k = i-1; k<i+2; k++){
                if(k>=0 && k<field.length){
                    for(int p = j-1; p<j+2; p++){
                        if(p>=0 && p<field[0].length && field[k][p]!=-1){
                            field[k][p] = field[k][p]+1;
                        }
                }

                }
            }

        }
        return field;
    }


}
