import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        block1();
        block2();
        block3();
        System.out.println(result);
    }

    private static void block1() {
        for(int r = 0; r < n; r++) {
            if(r + 1 >= n) break;
            for(int c = 0; c < m; c++) {
                if(c + 1 >= m) break;
                int temp = map[r][c] + map[r + 1][c] +map[r + 1][c + 1];
                temp = Math.max(temp, map[r][c] + map[r + 1][c + 1] +map[r][c + 1]);
                temp = Math.max(temp, map[r][c] + map[r + 1][c] +map[r][c + 1]);
                temp = Math.max(temp, map[r + 1][c + 1] + map[r + 1][c] +map[r][c + 1]);

                result = Math.max(temp, result);
            }
        }
    }

    private static void block2() {
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                int temp = map[r][c];
                if(c + 2 >= m) break;

                temp += map[r][c + 1];
                temp += map[r][c + 2];

                result = Math.max(temp, result);
            }
        }
    }

    private static void block3() {
        for(int r = 0; r < n; r++) {
            if(r + 2 >= n) break;
            for(int c = 0; c < m; c++) {
                int temp = map[r][c];

                temp += map[r + 1][c];
                temp += map[r + 2][c];

                result = Math.max(temp, result);
            }
        }
    }
}