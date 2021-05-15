package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P_2504 { // 문제 2054 : 괄호의 값

    // 올바른 괄호 문자열인지 판별하는 method
    public static boolean isValidation(String str){
        boolean isValid = true;
        int len = str.length();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if(c == '(' || c == '['){
                stack.addLast(c);
            }else{
                if(stack.isEmpty()) {
                    isValid = false;
                    break;
                }

                char top = stack.peekLast();
                if(top == '(' && c != ')'){
                    isValid = false;
                    break;
                }else if(top == '[' && c != ']'){
                    isValid = false;
                    break;
                }

                stack.pollLast();
            }
        }

        if(stack.size() > 0){
            isValid = false;
        }

        return isValid;
    }

    // 괄호 점수를 구하는 method
    public static void getScore(String str){
        int len = str.length();
        int answer = 0;
        // new Stack은 Vector를 상속받아 만들어지므로 되도록 사용 x
        Deque<String> stack = new ArrayDeque<>();
        int num = 0;
        int mux = 0;
        for (int i = 0; i < len; i++) {
            String s = str.charAt(i)+"";
            // 여는 괄호는 insert
            if(s.equals("[")  || s.equals("(")){
                stack.addLast(s);
            }else{
                String top = stack.pollLast();
                // 닫는 괄호의 짝이 맞을 경우 괄호에 따라 num = 2 or num = 3
                if(s.equals("]") && top.equals("[")) {
                    num = 3;
                }else if(s.equals(")") && top.equals("(")) {
                    num = 2;
                }else { // 괄호 안에 숫자가 들어있는 경우 -> [[]] -> [3]
                    mux = s.equals(")") ? 2 : 3;
                    stack.pollLast();
                    // 중복 괄호임으로 * 연산
                    num *= mux;
                }

                // 스택이 비어있지않고
                if(!stack.isEmpty()){
                    top = stack.peekLast();
                    // 다음 문자열이 여는 괄호가 아닌 숫자일 경우
                    if(!top.equals("[") && !top.equals("(")){
                        // 해당 숫자값을 num에 더한다
                        num += Integer.parseInt(stack.pollLast());
                    }
                }
                // 최종 계산된 숫자를 다시 stack에 저장
                stack.addLast(String.valueOf(num));
            }
        }

        answer = Integer.parseInt(stack.pollLast());
        System.out.println(answer);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (isValidation( str)) {
            getScore(str);
        }else{
            System.out.println(0);
        }

    }
}
