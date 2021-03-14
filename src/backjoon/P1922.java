package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1922 { //네트워크 연결

    static class Node{
        int a;
        int b;
        int weight;

        public Node(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }

    public static int find(int[] parents, int a){
        if(parents[a] == a) return a;
        else return find(parents, parents[a]);
    }

    public static void union(int[] parents, int[] rank, int a, int b){
        int x = find(parents, a);
        int y = find(parents, b);

        if(x == y) return;

        if(rank[x] < rank[y]){
            parents[y] = x;
        }else{
            parents[x] = y;
            if(rank[x] == rank[y]) rank[y]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] parents = new int[n + 1];
        int[] rank = new int[n + 1];

        for(int i=1; i<=n; i++){
            parents[i] = i;
        }

        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, weight));
        }

        Collections.sort(list, (n1,n2)->n1.weight-n2.weight);
        long answer = 0L;
        for(int i=0; i<m; i++){
            Node node = list.get(i);
            int a = find(parents,  node.a);
            int b = find(parents, node.b);

            if(a == b) continue;

            union(parents, rank, a, b);
            answer += node.weight;
        }

        System.out.println(answer);
    }
}
