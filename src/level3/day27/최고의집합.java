package level3.day27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 최고의집합 {
    public static int[] solution(int n, int s) {
        int[] answer = {};

        if(s/n == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        answer = new int[n];
        int mod = s%n;
        int check = mod;
        for (int i = n - 1; i >= n; i--) {
            int cnt = 0;
            if(mod > 0){
                cnt = 1;
                --mod;
            }
            answer[i] = (s / n) + cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(3,10);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
