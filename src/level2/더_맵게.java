package level2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }

        int food = 0;
        while (pq.peek() < K){ // 가장 낮은 스코빌 지수가 K보다 작으면
            food = pq.poll();
            food += (pq.poll() * 2); // 계산
            pq.offer(food);
            ++answer;

            if(pq.size() == 1) { // 하나만 남았을 때
                if (pq.peek() < K) answer = -1; // K보다 작으면 -1
                break;
            }
        }
        return answer;
    }
}
