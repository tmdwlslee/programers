package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < t; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                sum -= stack.peek();
                stack.pop();
            }else{
                stack.push(number);
                sum += number;
            }
        }
        System.out.println(sum);

    }
}
