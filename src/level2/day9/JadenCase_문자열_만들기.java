package level2.day9;

import java.util.StringTokenizer;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder answer = new StringBuilder();
        boolean check = false;

        for(int i=0; i<sb.length(); i++){
            String temp = sb.charAt(i)+"";
            if(temp.equals(" ")){
                check = false;
                answer.append(" ");
            }else{
                if(!check){
                    answer.append(temp.toUpperCase());
                }else{
                    answer.append(temp.toLowerCase());
                }
                check = true;
            }
        }

        return answer.toString();
    }
}
