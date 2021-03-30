package level3.day27;

import java.util.ArrayList;

public class 하노이탑 {
    public static ArrayList<Route> list = new ArrayList<>();
    static class Route{
        int start;
        int end;

        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public void Hanoi(int n, int start, int mid, int to) {
        if(n == 1){
            list.add(new Route(start, to));
            return;
        }

        Hanoi(n - 1, start, to, mid);

        list.add(new Route(start, mid));

        Hanoi(n - 1, mid, start, to);
    }

    public int[][] solution(int n) {
        int[][] answer = {};

        Hanoi(n, 1, 2, 3);

        answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).end;
        }


        return answer;
    }
}
