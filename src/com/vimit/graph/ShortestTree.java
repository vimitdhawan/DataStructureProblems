package com.vimit.graph;

import java.util.*;

// get shortest path
public class ShortestTree {
    public static void main(String[] args) {
        int N=3;
        int M=4;
        int[][] A= new int[][]{{1,0,0,0},
                {1,1,0,1},{0,1,1,1}};
        int X=2;
        int Y=3;
        ShortestTree tree = new ShortestTree();
        System.out.println(tree.getShortestPath(A, X, Y, N, M));
    }
    private static int getShortestPath(int[][] arr, int r, int s, int n , int m){
        int[][] dist = new int[n][m];
        for(int i =0; i<n; i++){
            Arrays.fill(dist[i],-1);
        }
        Queue<Point> queue = new LinkedList<>();
        dist[0][0]=0;
        queue.add(new Point(0,0));
        while(!queue.isEmpty()){
            Point point = queue.remove();
            if(point.x == r && point.y == s) return dist[r][s];
            if(isValid(arr,point.x-1, point.y) && dist[point.x-1][point.y]==-1){
                queue.add(new Point(point.x-1, point.y));
                dist[point.x-1][point.y] = dist[point.x][point.y]+1;
            }
            if(isValid(arr,point.x, point.y-1) && dist[point.x][point.y-1]==-1){
                queue.add(new Point(point.x, point.y-1));
                dist[point.x][point.y-1] = dist[point.x][point.y]+1;
            }
            if(isValid(arr,point.x+1, point.y) && dist[point.x+1][point.y]==-1){
                queue.add(new Point(point.x+1, point.y));
                dist[point.x+1][point.y] = dist[point.x][point.y]+1;
            }
            if(isValid(arr,point.x, point.y+1) && dist[point.x][point.y+1]==-1){
                queue.add(new Point(point.x, point.y+1));
                dist[point.x][point.y+1] = dist[point.x][point.y]+1;
            }
        }
        return -1;
    }

    private static boolean isValid(int[][] arr, int a, int b){
        return a>=0 && a<arr.length && b>=0 && b<arr[0].length && arr[a][b]==1;
    }

    private static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
