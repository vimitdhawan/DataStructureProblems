package com.vimit.graph;
import java.util.*;
public class RedundantConnection {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2}, {1,3}, {2,3}};
        RedundantConnection rc = new RedundantConnection();
        rc.findRedundantConnection(arr);

    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        Map<Integer,List<Integer>> graph = modelGraph(edges);
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[edges.length +1];
        detectCycle(graph ,1, -1, visited, set);
        for(int j=edges.length-1; j>=0; j--){
            if(set.contains(edges[j][0]) && set.contains(edges[j][1])){
                result[0] = edges[j][0];
                result[1] = edges[j][1];
            }
        }
        return result;
    }

    public Map<Integer,List<Integer>> modelGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i<edges.length; i++){
            List<Integer> nb = graph.getOrDefault(edges[i][0], new ArrayList<Integer>());
            nb.add(edges[i][1]);
            graph.put(edges[i][0], nb);
            List<Integer> nbr = graph.getOrDefault(edges[i][1], new ArrayList<Integer>());
            nbr.add(edges[i][0]);
            graph.put(edges[i][1], nbr);
        }
        return graph;
    }

    public boolean detectCycle(Map<Integer,List<Integer>> graph, int index, int parent, boolean[] visited, Set<Integer> set){
        visited[index] = true;
        List<Integer> nb = graph.getOrDefault(index,  new ArrayList<Integer>());
        for(int n : nb){
            if(!visited[n]){
                if(detectCycle(graph, n, index, visited, set)){
                    set.add(index);
                    set.add(n);
                    return true;
                }
            } else if(parent != n){
                set.add(n);
                set.add(index);
                return true;
            }
        }
        return false;
    }

}
