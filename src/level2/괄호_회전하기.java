package level2;

import java.util.Stack;

public class 괄호_회전하기 {

    public boolean checkStr(String s, int num) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int index = (i + num) % len;
            int preIndex = (i - 1 + num) % len;
            if (s.charAt(index) == '{') {
                stack.add('{');
            } else if (s.charAt(index) == '(') {
                stack.add('(');
            } else if (s.charAt(index) == '[') {
                stack.add('[');
            } else if (s.charAt(index) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else if (s.charAt(index) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }else{
                if(stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            }
        }

        if(stack.size() > 0)
            return false;

        return true;
    }

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (checkStr(s, i)) {
                answer++;
            }
        }

        return answer;
    }
}
