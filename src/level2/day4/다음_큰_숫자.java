package level2.day4;

public class 다음_큰_숫자 {

    public int getCnt(int n){
        int cnt = 0;
        int num = 0;

        while(n > 0){ // 2진수 1구하기
            num = n%2;
            n/=2;
            if(num == 1) ++cnt;
        }

        return cnt;
    }

    public int solution(int n) {
        int answer = 0;
        int cnt = 0;

        cnt = getCnt(n);

        for(int i=n+1; i<=1000000; i++){
            if(cnt == getCnt(i)){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
