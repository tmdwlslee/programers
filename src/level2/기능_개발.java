package level2;

import java.util.ArrayList;

public class 기능_개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        for(int i=0; i<progresses.length; i++){ // 기능 개발 공수를 먼저 계산한다.
            int temp = 100 - progresses[i];
            progresses[i] = (temp/speeds[i]);
            if(temp%speeds[i] > 0)
                progresses[i]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int preNum = progresses[0];
        int cnt = 1;
        for(int i=1; i<progresses.length; i++){ // 선행 기능 개발보다 공수가 작으면 ++
            if(preNum >= progresses[i]){
                ++cnt;
            }else{ // 아니면 배열에 넣고 cnt를 1로 초기화, 선행 기능 개발 공수 재설정
                list.add(cnt);
                cnt = 1;
                preNum = progresses[i];
            }
        }
        list.add(cnt); // 남은 cnt 추가

        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
