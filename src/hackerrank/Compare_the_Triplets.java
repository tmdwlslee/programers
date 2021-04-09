package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Compare_the_Triplets {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> answer = new ArrayList<>();

        int win1 = 0;
        int win2 = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                ++win1;
            } else if (a.get(i) < b.get(i)) {
                ++win2;
            }
        }

        answer.add(win1);
        answer.add(win2);

        return answer;
    }
}
