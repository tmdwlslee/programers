package level2.day4;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        if(s.length() == 0) return true;

        stack.push(s.charAt(0));
        char c;
        for(int i=1; i<s.length(); i++){
            c = s.charAt(i);
            if(c =='('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if (stack.peek() == '('){
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}
