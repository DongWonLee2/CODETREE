import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {

    static List<int []>[] adj;
    static int[] dist;
    static int[] path;
    static int INF = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList[n + 1];
        dist = new int[n + 1];
        path = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
            path[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u ,w});
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        dist[a] = 0;
        dijkstra(a);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[b]);
        System.out.println(sb);

        List<Integer> route = new ArrayList<>();
        int idx = b;
        while(idx != -1) {
            route.add(idx);
            idx = path[idx];
        }

        sb = new StringBuilder();
        for (int i = route.size() - 1; i >= 0; i--) {
            sb.append(route.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int sV) {
        Queue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[] {sV, 0});

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
                    path[nextV] = currV;

                    pq.offer(new int[] {nextV, tempD});
                }
            }
        }
    }
}