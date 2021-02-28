package level3.day14;

import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    class Program implements Comparable<Program>{
        int start;
        int end;
        double waitTime;
        double runTime;

        public Program(int start, int end, double waitTime, double runTime) {
            this.start = start;
            this.end = end;
            this.waitTime = waitTime;
            this.runTime = runTime;
        }

        @Override
        public int compareTo(Program o) {
            double pre = (this.waitTime + this.runTime)/this.runTime;
            double input = (o.waitTime + o.runTime)/o.runTime;

            if(input > pre){
                return 1;
            }else if(input == pre){
                return 0;
            }else{
                return -1;
            }
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        int endTime = jobs[0][1];
        int index = 0;
        PriorityQueue<Program> pq = new PriorityQueue<Program>();

        for(int i=1; i<jobs.length; i++){
            if(jobs[i][0] == endTime){
                endTime += jobs[i][1];
            }else{
                index = i;
                break;
            }
        }
        int temp = endTime;
        for(int i=index; i<jobs.length; i++){
            pq.offer(new Program(jobs[i][0], jobs[i][1],temp - jobs[i][0], jobs[i][1]));
            temp += jobs[i][1];
        }

        answer = endTime;
        while (!pq.isEmpty()){
            Program p = pq.poll();
            answer += (endTime - p.start) + p.end;
            endTime += p.end;
        }
        answer /= jobs.length;

        return answer;
    }
}
