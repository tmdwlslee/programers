package level2.day7;

import java.util.Stack;

public class 괄호변환 { // 아직 못 품

    public static String success = "";
    public static String fail = "";

    public static boolean checkString(String p){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(stack.peek() == '('){
                        stack.pop();
                    }
                }
            }
        }
        return stack.size() == 0 ? true : false;
    }

    public static void setString(String u){
        int left = 0;
        int right = 0;
        int index = 0;
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                ++left;
            }else{
                ++right;
            }

            if(left == right){
                index = i;
                break;
            }
        }
        System.out.println("index "+ index);
        if(index == u.length() - 1) {
            StringBuilder sb = null;
            if(fail.length() > 0){
                sb = new StringBuilder(fail);
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(0);
                System.out.println(sb.toString());
                for(int i=0; i<sb.length(); i++){
                    if(sb.charAt(i) == '('){
                        sb.setCharAt(i,')');
                    }else{
                        sb.setCharAt(i,'(');
                    }
                }

                success += "(" +u +")"+sb.toString();
            }else{
                sb = new StringBuilder(u);
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(0);
                for(int i=0; i<sb.length(); i++){
                    if(sb.charAt(i) == '('){
                        sb.setCharAt(i,')');
                    }else{
                        sb.setCharAt(i,'(');
                    }
                }
                sb.insert(0, "(");
                sb.append(")");
                success += sb.toString();
            }

            return;
        }
        System.out.println("u.substring(0,index+1) " +u.substring(0,index+1));
        System.out.println("u.substring(index,u.length()) "+ u.substring(index+1,u.length()));
        if(checkString(u.substring(0,index+1))){
            success += u.substring(0,index+1);
            System.out.println("sucess : "+success);
            setString(u.substring(index+1,u.length()));

        }else{
            fail += u.substring(0,index+1);
            System.out.println("fail : "+ fail);
            setString(u.substring(index+1,u.length()));

        }


    }

    public static String solution(String p) {
        String answer = "";

        if(checkString(p)){
            return p;
        }

        setString(p);

        return success;
    }

    public static void main(String[] args) {
        System.out.println(solution("()())("));
    }
}
