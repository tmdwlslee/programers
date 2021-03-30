package level3.day27;

public class 멀리뛰기 {
    public static long solution(int n) {
        long[] answer = new long[2001];

        answer[1] = 1;
        answer[2] = 2;
        for(int i=3; i<=2000; i++){
            answer[i] = (answer[i-1] + answer[i-2])%1234567;
        }

        //System.out.println(answer[n]);
        return answer[n];
    }

    public static void main(String[] args) {
        solution(4);
    }
}
