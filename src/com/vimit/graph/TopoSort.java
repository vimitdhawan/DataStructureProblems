package com.vimit.graph;

import java.util.*;
public class TopoSort {

    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i =0; i<V; i++){
            if(!visited[i]){
                traverse(adj, visited, i, result);
            }
        }
        Collections.reverse(result);
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public void traverse(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int index, List<Integer> result){
        visited[index] = true;
        ArrayList<Integer> neighbours = adj.get(index);
        for(Integer neigbour: neighbours){
            if(!visited[neigbour]){
                traverse(adj, visited, neigbour, result);
            }
        }
        result.add(index);
    }
}
