package com.vimit.crackig.coding.graph;

import java.util.*;
        import java.io.*;
        import java.lang.*;

public class BuildProblem  {
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

            int[] res = new Solution().topoSort(nov, list);

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

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class Solution {
    static int postorder =0;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Order> output = new ArrayList<>();
        for(int i =0; i<V; i++){
            if(!visited[i]){
                traverseNode(visited, i, adj, output);
            }
        }
        Collections.sort(output, (Order o1, Order o2) -> {
            return o2.postOrder-o1.postOrder;
        });

        int[] resp = new int[V];
        for(int t =0; t<V; t++){
            resp[t] = output.get(t).node;
        }
        return resp;

    }

    static void traverseNode(boolean[] visited, int node,  ArrayList<ArrayList<Integer>> adj, List<Order> output){
        visited[node] = true;
        postorder++;
        ArrayList<Integer> neighbours = adj.get(node);
        for(int j=0; j<neighbours.size(); j++){
            int traverseNode = neighbours.get(j);
            if(!visited[traverseNode]){
                traverseNode(visited, traverseNode, adj, output);
            }
        }
        postorder++;
        output.add(new Order(node, postorder));
    }

    static class Order{
        int node;
        int postOrder;
        Order(int node, int postOrder){
            this.node = node;
            this.postOrder = postOrder;
        }
    }
}
