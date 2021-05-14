package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_10828 { // 10828번 문제 : 스택
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.peek());
                    break;
            }

        }
    }
}
