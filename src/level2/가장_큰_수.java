package level2;

import java.util.ArrayList;
import java.util.Collections;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        String answer = "";

        for(int i=0; i<numbers.length; i++){
            list.add(String.valueOf(numbers[i]));
        }

        // 두 개의 수를 합쳐서 하나의 수로 만들었을 때 큰 쪽으로 정렬한다.
        Collections.sort(list,(o1,o2) -> Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2));
        StringBuffer sb = new StringBuffer();

        // 가장 큰 수가 0으로 시작하면 0을 return
        if(list.get(0).equals("0")){
            return "0";
        }

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
