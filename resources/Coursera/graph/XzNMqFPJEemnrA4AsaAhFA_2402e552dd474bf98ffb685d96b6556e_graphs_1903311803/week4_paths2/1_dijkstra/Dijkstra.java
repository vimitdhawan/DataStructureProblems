import java.util.*;

public class Dijkstra {
    private static final int inf = Integer.MAX_VALUE;

    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        Queue<Integer> queue = new PriorityQueue<>();
        int [] counter = new int [adj.length];
        queue.add(s);
        for (int i = 0;i < counter.length;i++) {
            counter[i] = Integer.MAX_VALUE;
        }
        counter[s]=0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            List<Integer> node = adj[current];
            List<Integer> costs = cost[current];
            for(int i =0; i<node.size(); i++){
                int edge = node.get(i);
                int costValue = costs.get(i);
                if(counter[edge]>counter[current]+costValue){
                    counter[edge] = counter[current]+costValue;
                    queue.add(edge);
                }


            }
        }

        if(counter[t]!=Integer.MAX_VALUE){
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

