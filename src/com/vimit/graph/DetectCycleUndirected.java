package com.vimit.graph;

import java.util.*;
public class DetectCycleUndirected {
    public static void main(String[] args) {
        DetectCycleUndirected ug = new DetectCycleUndirected();
        List<List<Integer>> adj = Arrays.asList(new ArrayList<>(), Arrays.asList(2), Arrays.asList(1,3), new ArrayList<>(2));

        System.out.println(ug.isCycle(4, adj));

    }
    public boolean isCycle(int V, List<List<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        for(int i =0; i<V; i++){
            if(!visited[i]){
                if(dfsCycle(adj, i, -1, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsCycle(List<List<Integer>> adj, int index, int parent,  boolean[] visited){
        visited[index] = true;
        List<Integer> neighbours = adj.get(index);
        for(int neigbour: neighbours){
            if(!visited[neigbour]){
                if(dfsCycle(adj, neigbour, index, visited)) return true;
            } else if(neigbour!=parent) return true;

        }
        return false;
    }

}
