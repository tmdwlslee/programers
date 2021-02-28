package level3.day14;

import java.util.ArrayList;
import java.util.Collections;

public class 단속카메라 {
    class Route{
        int start;
        int end;

        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int[][] routes) {
        int answer = 1;
        ArrayList<Route> list = new ArrayList<>();

        for(int i=0; i<routes.length; i++){
            list.add(new Route(routes[i][0], routes[i][1]));
        }

        Collections.sort(list, (r1, r2)-> r1.start - r2.start);

        int end = list.get(0).end;
        for(int i=1; i<list.size(); i++){
            Route r = list.get(i);
            System.out.println(r.start + " " + r.end);
            if(end < r.start){
                ++answer;
                end = r.end;
            }else if(end >= r.end){
                end = r.end;
            }
        }
        return answer;
    }
}
