package level3.day21;

public class 가장_긴_펠린드롬 {
    public static int solution(String s)
    {
        int answer = 1;

        if(s.length() == 0) answer = 0;

        for(int i=0; i<=s.length()/2; i++){
            for(int j=s.length()-1; j>i; j--){
                if(j - i + 1 < answer) continue;
                int start = i;
                int end = j;
                boolean check = true;
                while(start<end){
                    System.out.println(start + " " +end);
                    if(s.charAt(start) != s.charAt(end)){
                        check = false;
                        break;
                    }else{
                        ++start;
                        --end;
                    }
                }
                if(check){
                    System.out.println("j " + j+" i :"+i);
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("bbcsadawaaa");
    }
}
