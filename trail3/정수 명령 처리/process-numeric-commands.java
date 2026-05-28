import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String command = sc.next();

            if(command.equals("push")){
                int num = sc.nextInt();
                s.push(num);
            }
            else if(command.equals("pop")){
                sb.append(s.pop()).append("\n");
            }
            else if(command.equals("size")){
                sb.append(s.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(s.empty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else{
                sb.append(s.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}