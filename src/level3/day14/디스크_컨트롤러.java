package level3.day14;

import java.util.*;

public class 디스크_컨트롤러 {

    static class Program{
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int endTime = 0;
        int waitTime = 0;
        int index = 1;
        int temp = 0;

        Arrays.sort(jobs, (j1 , j2) -> j1[0] - j2[0]);
        PriorityQueue<Program> pq = new PriorityQueue<>(jobs.length, (p1,p2) -> p1.end - p2.end);
        PriorityQueue<Program> q = new PriorityQueue<>(jobs.length, (p1,p2)-> p1.start - p2.start);

        for(int i=0; i<jobs.length; i++){
            q.offer(new Program(jobs[i][0], jobs[i][1]));
        }

        Program p = q.poll();
        endTime =  p.end;
        waitTime = 0;

        while (!q.isEmpty()){
            p = q.poll();
            System.out.println("start " + p.start + " " + p.end+ " "+endTime);
           if(p.start <= endTime){
               pq.offer(new Program(p.start, p.end));
           }else{
               if(pq.isEmpty()){
                   endTime += p.end;
               }else{
                   q.offer(p);
                   while (true){
                       Program pp = pq.poll();
                       if(q.peek().start <= endTime) {
                           pq.offer(pp);
                           break;
                       }
                       waitTime += (endTime - pp.start);
                       endTime += pp.end;
                       System.out.println("add " +pp.start + " " + pp.end+ " "+endTime + " "+ waitTime);
                   }
               }

           }
        }
        while(!pq.isEmpty()){
            Program pp = pq.poll();
            waitTime += (endTime - pp.start);
            endTime += pp.end;
            System.out.println("add " +pp.start + " " + pp.end+ " "+endTime);
        }

        System.out.println(endTime+ " " + waitTime);
        endTime = (endTime + waitTime)/jobs.length;
        System.out.println(endTime);

        return endTime;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
        solution(arr);
    }
}
