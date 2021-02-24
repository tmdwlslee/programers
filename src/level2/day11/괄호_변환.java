package level2.day11;

public class 괄호_변환 {

    public static boolean checkString(String p){
        int cnt = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                ++cnt;
            }else{
                if(cnt == 0){
                    return false;
                }else{
                    --cnt;
                }
            }
        }
        return cnt == 0 ? true : false;
    }

    public static String getAnswer(String p){

        if(p.equals("") || checkString(p)) return p;

        int left = 0;
        int right = 0;
        int index = -1;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                ++left;
            }else{
                ++right;
            }

            if(left == right) {
                index = i;
                break;
            }
        }

        String u = p.substring(0, index+1);
        String v = p.substring(index+1 , p.length());

        if(checkString(u)){
            return u + getAnswer(v);
        }else{
            String temp = "(" + getAnswer(v) + ")";
            StringBuilder sb = new StringBuilder(u);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(0);
            for(int i=0; i<sb.length(); i++){
                if(sb.charAt(i) == '('){
                    sb.setCharAt(i, ')');
                }else{
                    sb.setCharAt(i, '(');
                }
            }
            return temp + sb.toString();
        }
    }

    public static String solution(String p) {
        String answer = "";

        if(checkString(p)){
            return p;
        }
        answer = getAnswer(p);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(")))((("));
    }

}
