import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if(!(command.equals("size") || command.equals("pop_back"))) {
                num = Integer.parseInt(st.nextToken());
            }
            
            if(command.equals("push_back")) {
                arr.add(num);
            }
            else if(command.equals("pop_back")){
                arr.remove(arr.size() - 1);
            }
            else if(command.equals("size")) {
                sb.append(arr.size()).append("\n");
            }
            else {
                sb.append(arr.get(num - 1)).append("\n");
            }

        }
        
        System.out.println(sb);
    }
}