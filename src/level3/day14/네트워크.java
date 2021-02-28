package level3.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static ArrayList[] list = new ArrayList[201];
    public static boolean[] check= new boolean[201];

    public static void checkEdge(int index){
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        check[index] = true;
        while (!q.isEmpty()){
            int node = q.poll();
            for(int i=0; i<list[node].size(); i++){
                int next = (int)list[node].get(i);
                if(!check[next]){
                    q.offer(next);
                    check[next] = true;
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for(int i=0; i<201; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[0].length; j++){
                if(i != j && computers[i][j] == 1)
                    list[i].add(j);
            }
        }

        for(int i=0; i<n; i++){
            if(!check[i]){
                checkEdge(i);
                ++answer;
            }
        }


        return answer;
    }
}
