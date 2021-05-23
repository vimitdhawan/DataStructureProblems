package com.vimit.interview.ByteDance;

// Find permutation of all topological sort

import java.util.*;
        import java.io.*;
        import java.lang.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new TopoSolution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class TopoSolution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        List<List<Integer>> resp = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                indegree[node]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        traverseGraph(adj, visited, result, resp, indegree, V);
        return resp.get(0).stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    static void traverseGraph(ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> result, List<List<Integer>> resp, int[] indegree, int V){
        boolean flag = false;
        for(int index=0; index<V; index++){
            if(!visited[index] && indegree[index]==0){
                result.add(index);
                visited[index]= true;
                ArrayList<Integer> neighbours = adj.get(index);
                for(int i: neighbours){
                    indegree[i]--;
                }
                traverseGraph(adj, visited, result, resp, indegree, V);
                for(int j: neighbours){
                    indegree[j]++;
                }
                visited[index]= false;
                result.remove(result.size()-1);
                flag = true;
            }
        }

        if(!flag){
            resp.add(result.stream().collect(Collectors.toList()));
        }

    }
}
