package level3;

import java.util.ArrayList;

public class 기지국설치 {

    static class Station{
        int start;
        int end;

        public Station(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = stations.length;
        int start = 1;
        int temp = w;
        w = 2*w + 1;
        for (int i = 0; i < len; i++) {
            int left = stations[i] - temp;
            int right = stations[i] + temp;
            if (left - start > 1) {
                start = left - start;
                answer += (start / w);
                if(start%w > 0) ++answer;
            }
            start = right + 1;
        }

        if(start <= n){
            answer += (n - start) / w;
            if((n - start) % w > 0) ++answer;
            System.out.println( (n+1) + " " + start);
        }

        return answer;
    }
}
