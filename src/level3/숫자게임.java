package level3;

import java.util.Arrays;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int aIndex = 0;
        int bIndex = 0;
        while (bIndex < B.length){
            if(A[aIndex] < B[bIndex]){
                answer++;
                aIndex++;
                bIndex++;
            }else{
                bIndex++;
            }
        }


        return answer;
    }
}
