package level1;

import java.util.HashMap;

public class 로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] result = {6,6,5,4,3,2,1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            map.put(lottos[i],map.getOrDefault(lottos[i], 0) + 1 );
        }

        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if (map.containsKey(win_nums[i])) {
                ++cnt;
            }
        }

        answer[1] = result[cnt];
        cnt += map.containsKey(0) ? map.get(0) : 0;
        answer[0] = result[cnt];

        return answer;
    }
}
