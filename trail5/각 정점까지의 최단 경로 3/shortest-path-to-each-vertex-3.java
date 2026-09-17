import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {

    static int n, m;
    static List<int []>[] adj;
    static int[] dist;
    static final int INF = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj[u].add(new int[] {v, w});
        }

        dist[1] = 0;
        dijkstra(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            int d = dist[i];
            if(d != INF) {
                sb.append(d).append("\n");
            }
            else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(int startV) {
        Queue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for(int i = 1; i <= n; i++) {
            pq.offer(new int[] {i, dist[i]});
        }

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currV = curr[0];
            int currD = curr[1];

            // 이미 더 짧은 경로가 발견된 옛날 정보면 무시
            if (currD > dist[currV]) {
                continue;
            }

            for (int[] to : adj[currV]) {
                int nextV = to[0];
                int weight = to[1];

                int newDist = currD + weight;

                if (dist[nextV] > newDist) {
                    dist[nextV] = newDist;

                    pq.offer(new int[]{nextV, newDist});
                }
            }
        }
    }
}