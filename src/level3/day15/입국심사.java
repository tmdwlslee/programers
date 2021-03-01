package level3.day15;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 입국심사 {
    public long solution(int n, int[] times) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long answer = 0;
        int index = 0;
        int mod = times.length;

        Arrays.sort(times);
        for(int i=0; i<times.length; i++){
            pq.offer((long)times[i]);
        }
        while(n > 1){
            --n;
            long time = pq.poll();
            answer = time;
            pq.offer(time + times[index%mod]);
            ++index;
        }

        return answer;
    }
}
