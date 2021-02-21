package level2.day9;

import java.util.Arrays;

public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int size = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<size; i++){
            answer += (A[i] * B[size - 1 - i]);
        }

        return answer;
    }
}
