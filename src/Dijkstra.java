import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
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

public class Dijkstra {

    public static void dijkstra(ArrayList<Edge>[] list, int[] d, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if(d[e.vertex] < e.weight) continue;
            for (int i = 0; i < list[e.vertex].size(); i++) {
                Edge next = list[e.vertex].get(i);
                int nextDist = e.weight + next.weight;
                System.out.println("E " + e.vertex + " next " + next.vertex + " nextDist " + nextDist);
                if (d[next.vertex] > nextDist) {
                    d[next.vertex] = nextDist;
                    pq.offer(new Edge(next.vertex, nextDist));
                }

            }
        }

    }

    public static void main(String[] args) {
        int[] d = new int[7];
        ArrayList<Edge>[] list = new ArrayList[7];
        for(int i=0; i<=6; i++){
            list[i] = new ArrayList<>();
            d[i] = 1000000000;
        }

        list[1].add(new Edge(2, 2));
        list[1].add(new Edge(3, 5));
        list[1].add(new Edge(4, 1));

        list[2].add(new Edge(1, 2));
        list[2].add(new Edge(3, 3));
        list[2].add(new Edge(4, 2));

        list[3].add(new Edge(1, 5));
        list[3].add(new Edge(2, 3));
        list[3].add(new Edge(4, 3));
        list[3].add(new Edge(5, 1));
        list[3].add(new Edge(6, 5));

        list[4].add(new Edge(1, 1));
        list[4].add(new Edge(2, 2));
        list[4].add(new Edge(3, 3));
        list[4].add(new Edge(5, 1));

        list[5].add(new Edge(3, 1));
        list[5].add(new Edge(4, 1));
        list[5].add(new Edge(6, 2));

        list[6].add(new Edge(3, 5));
        list[6].add(new Edge(5, 2));

        dijkstra(list, d, 1);

        for (int i = 0; i <= 6; i++) {
            System.out.println(d[i]);
        }
    }
}
