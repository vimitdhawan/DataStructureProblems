package com.vimit.coursera.graph;

// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }

            System.out.println(new Islands().findIslands(list, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Islands {

    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int[][] arr = new int[N][M];
        for(int k=0;k<N; k++){
            ArrayList<Integer> list = A.get(k);
            for(int t=0; t<M; t++){
                arr[k][t] = list.get(t);
            }
        }
        int islandCount = 0;
        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && arr[i][j]==1){
                    islandCount++;
                    visitReachableNodes(arr, visited, i, j, N, M);
                }
            }
        }

        return islandCount;

    }

    private static void visitReachableNodes(int[][] arr, boolean[][] visited, int i, int j, int N, int M) {
            visited[i][j] = true;
            if(i-1>=0 && j-1>=0 && arr[i-1][j-1]==1 && !visited[i-1][j-1]){
                visitReachableNodes(arr, visited, i-1, j-1, N, M);
            }

            if(i-1>=0 &&arr[i-1][j] == 1 && !visited[i-1][j]){
                visitReachableNodes(arr, visited, i-1, j, N, M);
            }

            if(j-1>=0 && arr[i][j-1] == 1 && !visited[i][j-1] ){
                visitReachableNodes(arr, visited, i, j-1, N, M);
            }

            if(i+1<=N-1 && j+1<=M-1 && arr[i+1][j+1]==1 && !visited[i+1][j+1]){
                visitReachableNodes(arr, visited, i+1, j+1, N, M);
            }

            if(i+1<=N-1 && j-1>=0 && arr[i+1][j-1]==1 && !visited[i+1][j-1]){
                visitReachableNodes(arr, visited, i+1, j-1, N, M);
            }
            if(i-1>=0 && j+1<=M-1 && arr[i-1][j+1]==1 && !visited[i-1][j+1]){
                visitReachableNodes(arr, visited, i-1, j+1, N, M);
            }

            if(i+1<=N-1 && arr[i+1][j] == 1 && !visited[i+1][j]){
                visitReachableNodes(arr, visited, i+1, j, N, M);
            }

            if(j+1<=M-1 && arr[i][j+1] == 1 && !visited[i][j+1]){
                visitReachableNodes(arr, visited, i, j+1, N, M);
            }
    }
}

