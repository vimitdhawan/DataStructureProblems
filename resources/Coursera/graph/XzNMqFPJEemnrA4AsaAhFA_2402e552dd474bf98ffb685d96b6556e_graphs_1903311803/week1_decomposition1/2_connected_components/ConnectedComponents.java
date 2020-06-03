import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        boolean[] visit = new boolean[adj.length];
        int result = 0;
        for(int x=0; x<adj.length; x++){
            if(!visit[x]){
                result++;
                isPathExist(adj, x, visit);
            }

        }

        //write your code here
        return result;
    }

    private static void isPathExist(ArrayList<Integer>[] adj, int x,  boolean[] visit){
        ArrayList<Integer> edge = adj[x];
        visit[x] = true;
        for(int i=0; i<edge.size(); i++){
            int temp = edge.get(i);
            if(!visit[temp]){
                isPathExist(adj, temp, visit);
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
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

