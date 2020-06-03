package com.vimit.coursera.graph;

import java.util.*;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[adj.length];
        int[] counter = new int[adj.length];
        queue.add(s);
        counter[s]=0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            List<Integer> node = adj[current];
            visit[current] = true;
            for(int i =0; i<node.size(); i++){
                int edge = node.get(i);
                if(!visit[edge]){
                    queue.add(edge);
                    if(counter[edge]!=0){
                        counter[edge] =  Math.min(counter[current]+1, counter[edge]);
                    } else {
                        counter[edge] = counter[current]+1;
                    }

                }
            }

        }
         if(counter[t]!=0){
             return counter[t];
         }

        //write your code here
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}
