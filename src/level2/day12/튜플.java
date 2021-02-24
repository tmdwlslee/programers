package level2.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class 튜플 {
    public static int[] solution(String s) {
        HashSet<Integer> set = new LinkedHashSet<>();
        int[] answer = {};

        String[] arr = s.substring(1,s.length()-1).split("}");
        Arrays.sort(arr,(o1,o2)-> o1.length() - o2.length());

        for(int i=0; i<arr.length; i++){
            String temp = arr[i].replace("{", "");
            String[] tempArr = temp.split(",");
            for(int j=0; j<tempArr.length; j++){
                if(!tempArr[j].equals("")){
                    set.add(Integer.parseInt(tempArr[j]));
                }
            }
        }
        answer = new int[set.size()];
        Iterator it = set.iterator();
        int index = 0;
        while (it.hasNext()){
            answer[index] = (int)it.next();
            ++index;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        solution(s);
    }
}
