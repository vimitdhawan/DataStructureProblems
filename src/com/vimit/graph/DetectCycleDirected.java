package com.vimit.graph;

import java.util.*;
public class DetectCycleDirected {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        boolean[] currentVisited = new boolean[V];
        for(int i =0; i<V; i++){
            if(!visited[i]){
                if(dfsCycle(adj, i, visited, currentVisited)){
                    return true;
                }
            }
        }
        return false; // code here
    }

    public boolean dfsCycle(ArrayList<ArrayList<Integer>> adj, int index,  boolean[] visited, boolean[] currentVisited ){
        visited[index] = true;
        currentVisited[index] = true;
        ArrayList<Integer> neighbours = adj.get(index);
        for(int neigbour: neighbours){
            if(!visited[neigbour]){
                if(dfsCycle(adj, neigbour, visited, currentVisited)) return true;
            } else if(currentVisited[neigbour]) return true;

        }
        currentVisited[index] = false;
        return false;
    }
}
