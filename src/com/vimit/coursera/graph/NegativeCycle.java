package com.vimit.coursera.graph;

import java.util.*;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        long [] counter = new long [adj.length];
        for (int i = 0;i < counter.length;i++) {
            counter[i] = Integer.MAX_VALUE;
        }
        counter[0]=0;
        for(int t =0; t<adj.length; t++){
            for(int k=0; k<adj.length; k++){
                List<Integer> node = adj[k];
                List<Integer> costs = cost[k];
                for(int p =0; p<node.size(); p++){
                    int edge = node.get(p);
                    int costValue = costs.get(p);
                    if(counter[edge]>counter[k]+costValue){
                        counter[edge] = counter[k]+costValue;
                        if(t==adj.length-1){
                            return 1;
                        }
                    }


                }
            }
        }

        //write your code here
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
    }
}
