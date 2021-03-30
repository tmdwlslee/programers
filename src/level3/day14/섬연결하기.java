package level3.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 섬연결하기 {

    class Node{
        int start;
        int end;
        int len;

        public Node(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }

    public static void union(int[] parent, int[] rank, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if(rank[a] > rank[b]) parent[b] = a;
        else {
            parent[a] = b;
            if (rank[a] == rank[b]) {
                rank[b]++;
            }
        }
    }

    public static int find(int[] parent, int x){
        if(parent[x] == x) return x;
        return find(parent, parent[x]);
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        int[] rank = new int[n];
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int i=0; i<costs.length; i++){
            list.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
        }

        Collections.sort(list, (n1, n2) -> n1.len - n2.len);

        for(int i=0; i<list.size(); i++){
            Node node = list.get(i);
            int a = find(parent, node.start);
            int b = find(parent, node.end);
            if(a == b) continue;
            union(parent, rank, a, b);
            answer += node.len;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] arr = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        //System.out.println(solution(n,arr));
    }
}
