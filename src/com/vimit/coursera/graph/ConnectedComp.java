package com.vimit.coursera.graph;

// Initial Template for Java
import java.util.*;
        import java.io.*;
        import java.lang.*;

public class ConnectedComp
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());

            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edgese between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for(int i=0; i<ptr.size(); i++)
            {
                for(int j=0; j<ptr.get(i).size(); j++)
                {
                    if(j+1==ptr.get(i).size())
                        System.out.print(ptr.get(i).get(j));
                    else
                        System.out.print(ptr.get(i).get(j) + " ");
                }
                System.out.print(",");
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    // adj : adjacency list of the graph
    // V : Number of vertices
    static int postOrder=0;
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();

        for(int p=0; p<adj.size(); p++){
            ArrayList<Integer> temp =  new ArrayList<Integer>();
            reverse.add(temp);

        }
        for(int i=0; i<adj.size(); i++){
            ArrayList<Integer> neighbours = adj.get(i);
            for(int t=0; t<neighbours.size(); t++){
                int elem = neighbours.get(t);
                ArrayList<Integer> temp = reverse.get(elem);
                temp.add(i);
            }
        }
        List<Element> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int r=0; r<V; r++){
            if(!visited[r]){
                traverseGraph(reverse, r, visited, list);
            }
        }
        Collections.sort(list, (Element e1, Element e2) -> {
            return e2.postNumber-e1.postNumber;
        });

        boolean[] visited1 = new boolean[V];

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int t=0; t<list.size(); t++){
            if(!visited1[list.get(t).elem]){
                ArrayList<Integer> tempResult = new ArrayList<>();
                traverseG(adj, list.get(t).elem, visited1, tempResult) ;
                result.add(tempResult);
            }

        }

        return result;

    }

    static void traverseG(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);
        ArrayList<Integer> neighbours = adj.get(node);
        for(int k =0; k<neighbours.size(); k++){
            int elem = neighbours.get(k);
            if(!visited[elem]){
                traverseG(adj, elem, visited, result);
            }
        }

    }


    static void traverseGraph(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, List<Element> result){
        visited[node] = true;
        postOrder++;
        ArrayList<Integer> neighbours = adj.get(node);
        for(int k =0; k<neighbours.size(); k++){
            int elem = neighbours.get(k);
            if(!visited[elem]){
                traverseGraph(adj, elem, visited, result);
            }
        }
        postOrder++;
        result.add(new Element(node, postOrder));

    }

    static class Element{
        int elem;
        int postNumber;
        Element(int n, int p){
            elem = n;
            postNumber=p;
        }
    }
}