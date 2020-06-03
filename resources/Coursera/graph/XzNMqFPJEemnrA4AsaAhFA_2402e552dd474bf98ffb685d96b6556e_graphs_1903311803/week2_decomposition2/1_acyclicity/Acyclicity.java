import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean[] visit = new boolean[adj.length+1];
        for(int i=0; i< adj.length; i++){
            isCycleExist(adj, i, i, visit);
            if(visit[adj.length]){
                return 1;
            }
        }

        //write your code here
        return 0;
    }

    private static void isCycleExist(ArrayList<Integer>[] adj, int x, int y,  boolean[] visit){
        ArrayList<Integer> edge = adj[x];
        visit[x] = true;
        for(int i=0; i<edge.size(); i++){
            int temp = edge.get(i);
            if(temp==y){
                visit[adj.length] = true;
            }
            if(!visit[temp]){
                isCycleExist(adj, temp, y, visit);
            }
        }

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
        }
        System.out.println(acyclic(adj));
    }
}

