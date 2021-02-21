package level2.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최댓값과최솟 {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        Collections.sort(list);

        answer = list.get(0) + " "+ list.get(list.size() - 1);

        return answer;
    }
}
