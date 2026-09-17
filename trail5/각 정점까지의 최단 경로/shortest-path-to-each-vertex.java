import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    
    static List<int []>[] adj;
    static int[] dist;
    static int INF = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        dist = new int[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
        
            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }
        
        dist[k] = 0;
        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(dist[i] == INF) sb.append(-1).append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int v) {
        Queue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[] {v, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currV = curr[0];
            int currD = curr[1];

            if(currD > dist[currV]) continue;

            for(int[] next : adj[currV]) {
                int nextV = next[0];
                int nextD = next[1];

                int tempD = nextD + currD;

                if(tempD < dist[nextV]) {
                    dist[nextV] = tempD;
                    pq.offer(new int[] {nextV, tempD});
                }
            }
        }
    }
}