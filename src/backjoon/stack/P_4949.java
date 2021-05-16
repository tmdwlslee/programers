package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P_4949 { // 문제 4949 : 균형잡힌 세상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();

        while (true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            stack.clear();
            int len = s.length();
            boolean check = true;
            System.out.println(s);
            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);
                if (c == '(' || c == '[') {
                    stack.addLast(c);
                }else if (c == ')' || c == ']') {
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }

                    char top = stack.peekLast();
                    if(top == '(' && c == ')'){
                        stack.pollLast();
                    } else if (top == '[' && c == ']') {
                        stack.pollLast();
                    } else{
                        check = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty() || !check){
                System.out.println("no");
                continue;
            }
            System.out.println("yes");
        }
    }
}
