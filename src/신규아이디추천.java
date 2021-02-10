import java.util.Locale;

public class 신규아이디추천 {

    public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        StringBuffer sb = new StringBuffer(new_id);
        StringBuffer temp = new StringBuffer();

        for (int i=0; i<sb.length(); i++){
            char c = sb.toString().charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c =='-' || c=='_' || c=='.'){
                temp.append(c);
            }
        }
        sb = new StringBuffer();

        for (int i=0; i<temp.length(); i++){
            char c = temp.toString().charAt(i);
            if(c=='.' && i < temp.length() - 1){
                if(temp.toString().charAt(i+1) != '.'){
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }
        }
        if(sb.length() > 0 && sb.toString().charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        if(sb.length() > 0 && sb.toString().charAt(sb.length()-1) == '.'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length() == 0){
            sb.append('a');
        }
        if(sb.length() > 15){
            sb = new StringBuffer(sb.substring(0, 15));
            if(sb.toString().charAt(14) == '.'){
                sb.deleteCharAt(14);
            }
        }
        char end = sb.toString().charAt(sb.length()-1);
        for(int i=sb.length(); i<3; i++){
            sb.append(end);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("=.="));
    }
}
