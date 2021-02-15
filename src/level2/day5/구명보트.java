package level2.day5;

import java.util.ArrayList;
import java.util.Collections;

public class 구명보트 { // 효율성 0점, 개선해야함.

    public static int solution(int[] people, int limit) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] score = new int[241];
        int answer = 0;

        for (int i=0; i<people.length; i++){
            score[people[i]]++;
        }
        int index = 40;
        while (index < 241){
            if(score[index] > 0){
                score[index]--;
                for(int j=score.length-1; j>=40; j--){
                    if(score[j] > 0){
                        if(index+j <= limit){
                            score[j]--;
                            break;
                        }
                    }
                }
                ++answer;
            }else{
                ++index;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {70,50,50,80};
        System.out.println(solution(arr, 100));
    }
}
