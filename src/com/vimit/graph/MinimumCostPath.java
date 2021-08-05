package com.vimit.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// Djsktra Algo
public class MinimumCostPath {
    public static void main(String[] args) {

    }

    public int minimumCostPath(int[][] grid)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.cost));
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i = 0; i< grid.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        pq.add(new Pair(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];
        while(!pq.isEmpty()){
            Pair currentPair = pq.poll();
            if(!visited[currentPair.x][currentPair.y]){
                if(currentPair.x == grid.length-1 && currentPair.y == grid[0].length-1) return currentPair.cost;
                else {
                    visited[currentPair.x][currentPair.y] = true;
                    if(isValid(currentPair.x+1, currentPair.y, grid) && dist[currentPair.x+1][currentPair.y]>currentPair.cost + grid[currentPair.x+1][currentPair.y]){
                        dist[currentPair.x+1][currentPair.y] = currentPair.cost + grid[currentPair.x+1][currentPair.y];
                        pq.add(new Pair(currentPair.x+1, currentPair.y, currentPair.cost + grid[currentPair.x+1][currentPair.y]));
                    }
                    if(isValid(currentPair.x-1, currentPair.y, grid) && dist[currentPair.x-1][currentPair.y]>currentPair.cost + grid[currentPair.x-1][currentPair.y]){
                        dist[currentPair.x-1][currentPair.y] = currentPair.cost + grid[currentPair.x-1][currentPair.y];
                        pq.add(new Pair(currentPair.x-1, currentPair.y, currentPair.cost + grid[currentPair.x-1][currentPair.y]));
                    }
                    if(isValid(currentPair.x, currentPair.y+1, grid) && dist[currentPair.x][currentPair.y+1]>currentPair.cost + grid[currentPair.x][currentPair.y+1]){
                        dist[currentPair.x][currentPair.y+1] = currentPair.cost + grid[currentPair.x][currentPair.y+1];
                        pq.add(new Pair(currentPair.x, currentPair.y+1, currentPair.cost + grid[currentPair.x][currentPair.y+1]));
                    }
                    if(isValid(currentPair.x, currentPair.y-1, grid) && dist[currentPair.x][currentPair.y-1]>currentPair.cost + grid[currentPair.x][currentPair.y-1]){
                        dist[currentPair.x][currentPair.y-1] = currentPair.cost + grid[currentPair.x][currentPair.y-1];
                        pq.add(new Pair(currentPair.x, currentPair.y-1, currentPair.cost + grid[currentPair.x][currentPair.y-1]));
                    }

                }

            }
        }
        return 0;
        // Code here
    }

    boolean isValid(int x, int y, int[][] grid){
        return x>=0 && y>=0 && x< grid.length && y < grid[0].length;
    }

}

class Pair {
    int x;
    int y;
    int cost;
    public Pair(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

}
