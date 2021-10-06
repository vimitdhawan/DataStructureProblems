package com.vimit.graph;

public class ConnectedComponentUndirected {
    public int numIslands(char[][] grid)
    {
        int islands = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(isValid(grid, i, j)){
                    traverse(grid, i, j);
                    islands++;
                }
            }

        }
        return islands;
    }

    public void traverse(char[][] grid, int row, int col){
        grid[row][col] = '0';
        for(int rowIndex = Math.max(0, row-1); rowIndex<Math.min(row+2,grid.length); rowIndex++){
            for(int colIndex = Math.max(0, col-1); colIndex<Math.min(col+2,grid[0].length); colIndex++){
                if(isValid(grid, rowIndex, colIndex)){
                    traverse(grid, rowIndex, colIndex);
                }
            }
        }

    }

    public boolean isValid(char[][] grid, int row, int col){
        return row>=0 && col>=0 && row < grid.length && col<grid[0].length && grid[row][col] == '1';
    }
}
