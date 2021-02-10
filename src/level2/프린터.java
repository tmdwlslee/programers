package level2;

import java.util.LinkedList;
import java.util.Queue;

class Paper{
    int index;
    int prior;

    public Paper(int index, int prior) {
        this.index = index;
        this.prior = prior;
    }
}

public class 프린터 {
    public int solution(int[] priorities, int location) {
        Queue<Paper> list = new LinkedList<>();
        Queue<Paper> sortQ = new LinkedList<>();
        int answer = 0;

        for(int i=0; i<priorities.length; i++){
            list.offer(new Paper(i,priorities[i]));
        }

        while(!list.isEmpty()){
            Paper p = list.poll();
            Queue<Paper> tq = new LinkedList<>(list);
            boolean check = true;
            while(!tq.isEmpty()){ // 우선순위가 큰게 있는지 확인
                Paper temp = tq.poll();
                if(p.prior < temp.prior){ // 있으면 맨 뒤로
                    check = false;
                    list.offer(p);
                    break;
                }
            }

            if(check){ // 자신이 제일 크면
                sortQ.add(p);
                if(p.index == location){ // index 와 location이 같다면
                    answer = sortQ.size();
                    break;
                }
            }
        }
        return answer;
    }
}
