package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for(int i=0; i<clothes.length; i++){ // 중복되는 의상 제거
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(Entry<String, Integer> e : hm.entrySet()) { // 경우의 수 계산
            answer *= (e.getValue() + 1); // 입지 않는 경우의 수를 생각하여 +1
        }

        /* EX) 얼굴 : A,B 바지 : C,D
        *  얼굴 장식을 입을 경우의 수는 아래와 같다.
        *  A를 입거나 B를 입거나 둘 다 입지 않거나 총 3개
        *  바지도 위와 동일
        *  C를 입거나 D를 입거나 둘 다 입지 않거나 총 3개
        *  경우의 수 계산 3*3 = 9
        *  하지만 얼굴, 바지 둘 다 입지 않는 경우가 포함되어 있으니 마지막에 -1
        * */

        --answer;

        return answer;
    }
}
