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
    static List<Integer> route;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList[n + 1];
        dist = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            adj[x].add(new int[] {y, z});
            adj[y].add(new int[] {x, z});
        }
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 1; i <= n; i++) {
           adj[i].sort(Comparator.comparingInt(t -> t[0]));
        }

        dist[b] = 0;
        dijkstra(b);

        route = new ArrayList<>();

        calc(a, b);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[a]).append("\n");
        for(int i : route) {
            sb.append(i).append(" ");
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

                int tempD = currD + nextD;

                if(tempD < dist[nextV]) {
                    dist[nextV] = tempD;

                    pq.offer(new int[] {nextV, tempD});
                }
            }
        }
    }

    private static void calc(int sV, int eV) {
        route.add(sV);

        int idx = sV;
        while(idx != eV) {
            for(int[] from : adj[idx]) {
                int fromV = from[0];
                int fromD = from[1];

                if(dist[fromV] + fromD == dist[idx]) {
                    route.add(fromV);
                    idx = fromV;
                    break;
                }
            }
        }

    }
}