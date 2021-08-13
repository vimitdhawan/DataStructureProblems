package com.vimit.graph;

import java.util.*;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        traverse(adj, visited, 0, result);
        return result;

    }

    public void traverse(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int index, ArrayList<Integer> result){
        visited[index] = true;
        result.add(index);
        ArrayList<Integer> neighbours = adj.get(index);
        for(Integer neigbour: neighbours){
            if(!visited[neigbour]){
                traverse(adj, visited, neigbour, result);
            }
        }
    }
}
