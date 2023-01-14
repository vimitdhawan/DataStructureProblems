package com.vimit.graph;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;




class PathExist
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        Position source = getPosition(grid, 1);
        Position destination = getPosition(grid, 2);
        Stack<Position> stack = new Stack<>();
        stack.push(source);
        boolean isFound = false;
        while(!isFound && !stack.isEmpty()){
            Position currentElement = stack.pop();
            if(currentElement.row == destination.row && currentElement.column == destination.column){
                isFound = true;
            } else {
                grid[currentElement.row][currentElement.column] = -1;
                Position up = new Position(currentElement.row+1, currentElement.column);
                Position down = new Position(currentElement.row-1, currentElement.column);
                Position right = new Position(currentElement.row, currentElement.column+1);
                Position left = new Position(currentElement.row, currentElement.column-1);
                if(isValidPosition(grid, up)){
                    stack.push(up);
                }
                if(isValidPosition(grid, down)){
                    stack.push(down);
                }
                if(isValidPosition(grid, right)){
                    stack.push(right);
                }
                if(isValidPosition(grid, left)){
                    stack.push(left);
                }
            }


        }

        return isFound;
    }

    private boolean isValidPosition(int[][] grid, Position pos){
        boolean validIndex = pos.row >=0 && pos.row <grid.length && pos.column>=0 && pos.column<grid[0].length;
        return validIndex && grid[pos.row][pos.column] == 3 ;
    }

    private Position getPosition(int[][] grid, int value){
        Position position = new Position(0,0);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==value){
                    position = new Position(i, j);
                }
            }
        }
        return position;
    }

}

class Position{
    int row;
    int column;
    Position(int row, int column){
        this.row = row;
        this.column = column;
    }
}