package com.vimit.crackig.coding.ArrayString;

//Initial Template for Java
/*
1
3
1 2 3 4 5 6 7 8 9
*/

import java.util.*;
        import java.io.*;
        import java.lang.*;

public class RotateMatrix
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix (arr);
        }
    }

    static void printMatrix(int arr[][])
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class GFG
{
    static void rotate(int matrix[][])
    {
        int matrixLength = matrix.length;
        for(int i =0; i<matrixLength; i++){
            int forward = 0;
            int backward = matrixLength-1;
            while(forward<backward){
                int temp = matrix[i][forward];
                matrix[i][forward] = matrix[i][backward];
                matrix[i][backward] = temp;
                forward++;
                backward--;
            }
        }

        for(int j =0; j<matrixLength; j++){
            for(int k =j; k<matrixLength; k++){
                int temp = matrix[j][k];
                matrix[j][k] = matrix[k][j];
                matrix[k][j] = temp;
            }

        }

    }
}
