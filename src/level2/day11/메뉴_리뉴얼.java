package level2.day11;

import java.text.CollationElementIterator;
import java.util.*;

public class 메뉴_리뉴얼 {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static int[] max = new int[20];

    public static void getString(String s, String make, int index, int len, int end, int maxIndex){
        System.out.println(make);
        if(len == end){
            map.put(make, map.getOrDefault(make, 0) + 1);
            if(max[maxIndex] < map.get(make)){
                max[maxIndex] = map.get(make);
            }
            return;
        }

        for(int i=index; i<s.length(); i++){
            getString(s, make+s.charAt(i),i+1, len+1, end, maxIndex);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer;

        for(int i=0; i<orders.length; i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = new String(c);
        }

        for(int i=0; i<course.length; i++){
            for(int j=0; j<orders.length; j++){
                if(orders[j].length() >= course[i]){
                    getString(orders[j], "", 0, 0, course[i], i);
                }
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            for(int i=0; i<course.length; i++){
                if(max[i] > 1){
                    String temp = entry.getKey();
                    if(entry.getValue() == max[i] && temp.length() == course[i]) list.add(entry.getKey());
                }
            }
        }

        Collections.sort(list);
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"XYZ", "XWY", "WXA"} ;
        int[] arr1 = {2,3,4};
        solution(arr, arr1);
    }
}
