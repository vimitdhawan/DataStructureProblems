package com.vimit.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueenProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> output = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            boolean[][] grid = new boolean[n][n];

            traverseGrid(0, n,grid, output, result);
            for(int k=0; k<output.size(); k++){
                List<Integer> l = output.get(k);
                System.out.print("[");
                for(int p=0; p<l.size(); p++){
                    System.out.print(l.get(p)+" ");
                }
                System.out.print("] ");
            }
            if(output.size()==0)System.out.print(-1);
            System.out.println();
        }
    }

    private static void traverseGrid(int col,  int n, boolean[][] grid, List<List<Integer>> output, List<Integer> result) {
        if(col == n){
            if(result.size()==n){
                List<Integer> res = new ArrayList<>();
                for(int t=0; t<result.size(); t++){
                    res.add(result.get(t));
                }
                output.add(res);
            }

            return;
        }

        for(int i=0; i<n; i++){
            if(saveMove(i, col, grid, n)){
                grid[i][col] = true;
                result.add(i+1);
                traverseGrid(col+1,  n, grid, output, result);
                result.remove(result.size()-1);
                grid[i][col] = false;
            }

        }
        return;
    }

    private static boolean saveMove(int row, int col, boolean[][] grid, int n) {
        for(int i=col; i>=0; i--){
            if(grid[row][i]){
                return false;
            }
        }
        for(int t=row, p=col; t<n && p>=0;t++, p-- ){
            if(grid[t][p]){
                return false;
            }
        }
        for(int a=row, b=col; a>=0 && b>=0;a--, b-- ){
            if(grid[a][b]){
                return false;
            }
        }
        return true;

    }
}
