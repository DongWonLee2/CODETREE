import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        int max = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                int result = 0;
                for(int r = i; r < i + 3; r++) {
                    for(int c = j; c < j + 3; c++) {
                        if(map[r][c] == 1)
                        result++;
                    }
                }
                max = Math.max(result, max);
            }
        }

        System.out.println(max);
    }
}