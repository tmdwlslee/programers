package level2.day9;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int num = 0;
        for(int i=1; i<=10000; i++){
            num = i;
            if(i == n){
                ++answer;
                break;
            }
            for(int j=i+1; j<=10000; j++){
                if(num < n){
                    num += j;
                }else if(num > n){
                    break;
                }else{
                    ++answer;
                    break;
                }
            }
        }
        return answer;
    }
}
