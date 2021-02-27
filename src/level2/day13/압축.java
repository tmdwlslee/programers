package level2.day13;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {
    public static int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};
        for(int i=1; i<=26; i++){
            char c = (char)('A' + (i-1));
            map.put(c+"", i);
        }
        int size = msg.length();
        int index = 27;
        for(int i=0; i<size; i++){
            for(int j=size; j>=i; j--){
                //System.out.println(i + " " + j);
                String word = msg.substring(i,j);
                //System.out.println("word " + word);
                if(map.containsKey(word)){
                    list.add(map.get(word));
                    if(j < size)
                        map.put(msg.substring(i,j+1), index);
                    i = j-1;
                    ++index;
                    break;
                }
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("KAKAO");
    }
}
