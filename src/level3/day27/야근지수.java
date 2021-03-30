package level3.day27;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        long answer = 0;
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }

        while(n > 0){
            int num = pq.poll();
            if(num == 0) break;
            num--;
            n--;
            pq.offer(num);
        }

        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
