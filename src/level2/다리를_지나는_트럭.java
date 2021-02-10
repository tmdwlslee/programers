package level2;

import java.util.LinkedList;
import java.util.Queue;

class Truck{
    int weight;
    int sec;

    public Truck(int weight, int sec) {
        this.weight = weight;
        this.sec = sec;
    }
}

public class 다리를_지나는_트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> list = new LinkedList<>(); // 대기중인 트럭
        Queue<Truck> bridge = new LinkedList<>(); // 다리를 건너는 중인 트럭
        int answer = 0;
        int waitTruckCnt = 0;
        int moveTruckCnt = 0;
        for (int i =0; i<truck_weights.length; i++){
            list.offer(new Truck(truck_weights[i],0));
        }

        while (!list.isEmpty() || !bridge.isEmpty()){ // 대기중이거나 다리 위에 트럭이 없다면
            waitTruckCnt = list.size();
            moveTruckCnt = bridge.size();
            Truck t = null;
            for(int i=0; i<moveTruckCnt; i++){ // 다리 위에 있는 트럭 1칸씩 이동
                t = bridge.poll();
                if(t.sec + 1 <= bridge_length){
                    t.sec += 1;
                    bridge.offer(t);
                }else{
                    weight += t.weight;
                }
            }
            moveTruckCnt = bridge.size();
            if(waitTruckCnt > 0) { // 대기하고 있는 트럭이 있으면 
                t = list.peek();
                if (weight - t.weight >= 0 && moveTruckCnt < bridge_length) { // 다리의 무게를 넘지않고 길이의 여유가 있다면
                    t.sec += 1;
                    weight -= t.weight;
                    bridge.offer(t);
                    list.poll();
                }
            }
            ++answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {10,10,10,10,10,10,10,10,10,10};
        int[] arr2 = {7,4,5,6};
        System.out.println(solution(100, 100, arr));
    }

}
