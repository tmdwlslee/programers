package level3.day15;

import java.util.*;

public class 이중우선순위큐 {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(operations.length, (n1,n2) -> n2-n1);
        int[] answer = new int[2];

        for(int i=0; i<operations.length; i++){
            String[] cmd = operations[i].split(" ");
            if(cmd[0].equals("D")){
                if(cmd[1].equals("1")){
                    if(!pqDesc.isEmpty()){
                        pqDesc.poll();
                    }
                }else{
                    if(!pqAsc.isEmpty()){
                        pqAsc.poll();
                    }
                }
            }else{
                pqAsc.offer(Integer.parseInt(cmd[1]));
                pqDesc.offer(Integer.parseInt(cmd[1]));
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        while(!pqAsc.isEmpty()){
            int num = pqAsc.poll();
            map.put(num, map.getOrDefault(num,0)+1);
        }

        while(!pqDesc.isEmpty()){
            int num = pqDesc.poll();
            map.put(num, map.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 2){
                list.add(entry.getKey());
            }
        }
        if(list.size() < 2) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        Collections.sort(list);

        answer[0] = list.get(list.size()-1);
        answer[1] = list.get(0);

        return answer;
    }

    public static void main(String[] args) {
        String[] s = {"I 16","D 1"};
        solution(s);
    }
}
