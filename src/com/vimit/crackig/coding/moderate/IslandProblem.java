package com.vimit.crackig.coding.moderate;

/*
1
4 2
0 1
1 0
1 1
1 0
*/
import java.util.*;
        import java.lang.*;
        import java.io.*;
public class IslandProblem
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = S[j].charAt(0);
                }
            }
            IslandProblemSolution obj = new IslandProblemSolution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends





class IslandProblemSolution
{
    //Function to find the number of islands.
    public int numIslands(char[][] grid)
    {
        int count =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    traverseIsland(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    public void traverseIsland(char[][] grid, int row, int col){
        if((row<0 || row>=grid.length || col<0 || col>=grid[0].length) || grid[row][col]!='1'){
            return;
        }
        grid[row][col] = 'a';
        for(int t=-1; t<2; t++){
            for(int p=-1; p<2; p++){
                int currentRow =  row+t;
                int currentCol = col+p;
                traverseIsland(grid, currentRow, currentCol);
            }
        }
    }
}