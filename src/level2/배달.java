package level2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 배달 {

    static class Edge implements Comparable<Edge>{
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public void dijkstra(ArrayList<Edge>[] list, int[] d, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if(d[e.vertex] < e.weight) continue;
            int len = list[e.vertex].size();
            for (int i = 0; i < len; i++) {
                Edge next = list[e.vertex].get(i);
                int nextDist = e.weight + next.weight;
                if (d[next.vertex] > nextDist) {
                    d[next.vertex] = nextDist;
                    pq.offer(new Edge(next.vertex, nextDist));
                }
            }
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] d = new int[N + 1];
        ArrayList<Edge>[] list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            d[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            list[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            list[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }

        dijkstra(list,d,1);


        for (int i = 1; i <= N; i++) {
            if (d[i] <= K) {
                ++answer;
            }
        }


        return answer;
    }
}
