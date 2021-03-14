package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1197 { // 최소 스패닝 트리
    public static int[] parents;
    public static int[] rank;
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

    public static int find(int a){
        if(parents[a]==a) return a;
        else return  find(parents[a]);
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

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

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parents = new int[v + 1];
        rank = new int[v + 1];

        for(int i=1; i<=v; i++){
            parents[i]=i;
        }

        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, weight));
        }

        Collections.sort(list,(n1, n2)->n1.weight-n2.weight);
        long answer = 0L;
        for(int i=0; i<e; i++){
            Node n = list.get(i);
            int a = find(n.a);
            int b = find(n.b);
            if(a == b) continue;

            union(a,b);
            answer += n.weight;
        }

        System.out.println(answer);
    }
}
