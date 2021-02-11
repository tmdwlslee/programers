package level2;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = Integer.MAX_VALUE;
        int size = citations.length;

        Arrays.sort(citations);
        for(int i=size-1; i>=0; i--){ // 뭔지 이해는 못하겠고 나무위키 공식보고 만듬
            if(size - i  <= citations[i]){
                answer = Math.min(answer, size - i);
            }
        }
        return answer;
    }
}
