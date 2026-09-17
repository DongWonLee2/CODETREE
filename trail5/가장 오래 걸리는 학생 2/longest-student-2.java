import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {

    static List<int []>[] adj;
    static int[] dist;
    static final int INF = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dist = new int[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
        
            adj[b].add(new int[] {a, d});
        }

        dist[n] = 0;
        dijkstra(n);

        int result = -1;
        for(int i = 1; i < n; i++) {
            if(dist[i] == INF) continue;

            result = Math.max(result, dist[i]);
        }

        System.out.println(result);
    }

    private static void dijkstra(int v) {
        Queue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int [] {v, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currV = curr[0];
            int currD = curr[1];

            if(currD > dist[currV]) continue;

            for(int[] next : adj[currV]) {
                int nextV = next[0];
                int nextD = next[1];

                int tempD = currD + nextD;

                if(tempD < dist[nextV]) {
                    dist[nextV] = tempD;
                    pq.offer(new int[] {nextV, tempD});
                }
            }
        }
    }
}