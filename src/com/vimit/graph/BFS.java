package com.vimit.graph;

import java.util.*;
public class BFS {
    public static void main(String[] args) {
    }

    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        if(V <= 0) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int element = queue.poll();
            result.add(element);
            for(int currentElement: adj.get(element)){
                if(!visited[currentElement]){
                    queue.offer(currentElement);
                    visited[currentElement] = true;
                }
            }

        }
        return result;
    }
}
