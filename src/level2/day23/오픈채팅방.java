package level2.day23;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

    static class People{
        String uid;
        boolean inOut;

        public People(String uid, boolean inOut) {
            this.uid = uid;
            this.inOut = inOut;
        }
    }

    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        ArrayList<People> list = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String[] cmd = record[i].split(" ");
            if(cmd[0].equals("Enter")){
                map.put(cmd[1], cmd[2]);
                list.add(new People(cmd[1],true));
            }else if(cmd[0].equals("Leave")){
                list.add(new People(cmd[1],false));
            }else{
                map.put(cmd[1], cmd[2]);
            }
        }

        answer = new String[list.size()];
        for(int i=0; i< list.size(); i++){
            People p = list.get(i);
            if(p.inOut){
                answer[i] = map.get(p.uid) + "님이 들어왔습니다.";
            }else{
                answer[i] = map.get(p.uid) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
