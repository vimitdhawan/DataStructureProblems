package com.vimit.graph;

import java.util.*;
public class BFS {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(3);
        queue.addFirst(5);
        System.out.println(queue.removeLast());
    }

    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        if(V <= 0) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        queue.addFirst(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int element = queue.removeFirst();
            result.add(element);
            for(int currentElement: adj.get(element)){
                if(!visited[currentElement]){
                    queue.add(currentElement);
                }
            }

        }
        return result;
    }
}
