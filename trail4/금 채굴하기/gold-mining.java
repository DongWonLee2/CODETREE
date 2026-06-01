import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 금 한 개 가격

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                for(int k = 0; k < 2 * n; k++) {
                    int gold = 0;

                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < n; j++) {
                            if((Math.abs(r - i) + Math.abs(c - j)) <= k) {
                                gold += map[i][j];
                            }
                        }
                    }

                    int cost = k * k + (k + 1) * (k + 1);
                    if(gold * m >= cost) {
                        result = Math.max(result, gold);
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}