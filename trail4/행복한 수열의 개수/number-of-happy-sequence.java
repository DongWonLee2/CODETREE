import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        // 행
        for(int r = 0; r < n; r++) {
            int count = 1;
            int max = 0;
            int last = map[r][0];
            for(int c = 1; c < n; c++) {
                if(map[r][c] == last) {
                    count++;
                } else {
                    last = map[r][c];
                    max = Math.max(count, max);
                    count = 1;
                }
            }
            max = Math.max(count, max);

            if(max >= m) {
                result++;
            }
        }

        // 열
        for(int c = 0; c < n; c++) {
            int count = 1;
            int max = 0;
            int last = map[0][c];
            for(int r = 1; r < n; r++) {
                if(map[r][c] == last) {
                    count++;
                } else {
                    last = map[r][c];
                    max = Math.max(count, max);
                    count = 1;
                }
            }
            max = Math.max(count, max);

            if(max >= m) {
                result++;
            }
        }

        System.out.println(result);
    }
}