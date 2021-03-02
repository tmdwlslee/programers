package level3.day16;

import java.util.Arrays;

public class P1 {
    public static int solution(int[] P, int[] S) {
        // write your code in Java SE 8
        int answer = 0;
        int people = 0;
        for(int i=0; i<P.length; i++){
            people += P[i];
        }
        System.out.println(people);
        Arrays.sort(S);
        for(int i=S.length-1; i>=0; i--){
            if(people < 0){
                break;
            }else{
                people -=S[i];
                ++answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {4,4,2,4};
        int[] arr1 = {5,5,2,5};
        solution(arr, arr1);
    }

}
