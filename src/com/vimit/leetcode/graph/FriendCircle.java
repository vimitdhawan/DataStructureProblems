package com.vimit.leetcode.graph;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FriendCircle {
    public static void main(String[] args) {
        FriendCircle fc = new FriendCircle();
        int[][] arr = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int res = fc.findCircleNum(arr);
        System.out.println(res);
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[][] visited = new boolean[isConnected.length][isConnected[0].length];
        int counter = 0;
        for(int i =0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(!visited[i][j] && isConnected[i][j]==1){
                    dfsGraph(isConnected,visited, i, j);
                    counter++;
                }

            }
        }
        return counter;
    }

    public void dfsGraph(int[][] isConnected, boolean[][] visited, int i , int j){
        if(isValid(isConnected, i, j, visited)){
            visited[i][j] = true;
            for(int t = Math.max(0,i-1); t<=Math.min(i+1,isConnected.length-1); t++){
                for(int k = Math.max(0,j-1); k<=Math.min(j+1,isConnected[0].length-1); k++){
                    dfsGraph(isConnected, visited, t, k);

                }
            }
        }

    }

    public boolean isValid(int[][] isConnected, int i , int j,  boolean[][] visited){
        return i>=0 && i<isConnected.length && j>=0 && j<isConnected[0].length && isConnected[i][j] == 1 && !visited[i][j];
    }

}
