package com.vimit.crackig.coding.graph;

import java.util.*;

public class Route {
    public static void main(String[] args) {
        Route route = new Route();
        int[][] arr = {{1,2},{3},{3},{}};
        route.allPathsSourceTarget(arr);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int vertices = graph.length;
        List<List<Integer>> output = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        traverse(visited,output, 0, vertices-1, list, graph);
        return output;

    }

    public void traverse(boolean[] visited,  List<List<Integer>> output, int start, int end, LinkedList<Integer> list, int[][] graph)  {
        list.add(start);
        visited[start] = true;
        if(start == end){
            List<Integer> newList= new ArrayList<>();
            for(int j =0; j<list.size(); j++){
                newList.add(list.get(j));
            }
            output.add(newList);
        } else{
            int[] traverse = graph[start];
            for(int i=0; i<traverse.length; i++){
                int node = traverse[i];
                if(!visited[node]){
                    traverse(visited, output, node, end, list, graph) ;
                }
            }
        }
        visited[start] = false;
        list.removeLast();

    }
}


