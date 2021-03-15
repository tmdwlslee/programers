package level2.day23;

import java.util.*;

public class 캐시 {
    public static int solution(int cacheSize, String[] cities) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        int answer = 0;
        int cnt = 0;
        if(cacheSize == 0) {
            return cities.length*5;
        }
        for(int i=0; i<cities.length; i++){
            System.out.println(cacheSize);
            cities[i] = cities[i].toUpperCase();
            if(cacheSize > 0 ){
                if(map.containsKey(cities[i])){
                    cnt = map.get(cities[i]);
                    map.remove(cities[i]);
                    map.put(cities[i], cnt + 1);
                    answer += 1;
                }else{
                    --cacheSize;
                    answer += 5;
                    map.put(cities[i], 1);
                }
            }else{
                if(map.containsKey(cities[i].toUpperCase())){
                    cnt = map.get(cities[i]);
                    map.remove(cities[i]);
                    map.put(cities[i], cnt + 1);
                    answer += 1;
                }else{
                    for(Map.Entry<String, Integer> entry : map.entrySet()){
                        map.remove(entry.getKey());
                        break;
                    }
                    answer += 5;
                    map.put(cities[i], 1);
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        solution(1, arr);
    }
}
