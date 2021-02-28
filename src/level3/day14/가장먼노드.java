package level3.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    class Node{
        int depth;
        int number;

        public Node(int depth, int number) {
            this.depth = depth;
            this.number = number;
        }
    }

    public int getAnswer(ArrayList[] list, boolean[] check){
        int cnt = 0;
        int len = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,1));
        check[1] = true;
        while (!q.isEmpty()){
            Node node = q.poll();
            int num = node.number;
            int depth = node.depth;
            if(depth != len) {
                len = depth;
                cnt = 0;
            }
            ++cnt;
            for(int i=0; i<list[num].size(); i++){
                int next = (int)list[num].get(i);
                if(!check[next]){
                    check[next] = true;
                    q.offer(new Node(depth+1, next));

                }
            }
        }


        return cnt;
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] check  = new boolean[n + 1];
        ArrayList[] list = new ArrayList[n + 1];

        for (int i=0; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }

        answer = getAnswer(list, check);

        return answer;
    }
}
