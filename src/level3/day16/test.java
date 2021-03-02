package level3.day16;

public class test {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] num = new int[1000001];
        for(int i=0; i<A.length; i++){
            if(A[i] > 0){
                num[A[i]]++;
            }
        }
        int answer = 0;
        for(int i=1; i<=1000000; i++){
            if(num[i] < 1){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
