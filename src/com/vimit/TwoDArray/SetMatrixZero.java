package com.vimit.TwoDArray;

import java.util.Arrays;
import java.util.Collections;

public class SetMatrixZero {
    public static void main(String[] args) {
       int[][] matrix =  {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(matrix[i][j]==0){
                    for(int k=0; k<rows; k++){
                        if(matrix[k][j]!=0) matrix[k][j]=-1;

                    }
                    for(int t=0; t<columns; t++){
                        if(matrix[i][t]!=0) matrix[i][t]=-1;
                    }
                }
            }
        }

        for(int p=0; p<rows; p++){
            for(int q=0; q<columns; q++){
                if(matrix[p][q]==-1){
                    matrix[p][q]=0;
                }
            }
        }


    }
}
