package level2;

public class _124나라의_숫자 {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();

        while(n > 0){
            int mod = n%3; // 숫자 3개를 나눈 나머지
            if(mod == 0){
                answer.insert(0,"4"); // 0일 때 n--
                n--;
            }else{
                answer.insert(0,mod);
            }
            n /=3;
        }

        return answer.toString();
    }
}
