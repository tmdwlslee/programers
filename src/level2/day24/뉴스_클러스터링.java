package level2.day24;

import java.util.HashMap;
import java.util.Map;

public class 뉴스_클러스터링 {
    public static int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int answer = 0;

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i=0; i<str1.length() - 1; i++){
            if(str1.charAt(i) >= 'A' && str1.charAt(i)<='Z'){
                if(str1.charAt(i + 1) >= 'A' && str1.charAt(i + 1)<='Z'){
                    String temp = str1.charAt(i)+"";
                    temp += str1.charAt(i + 1);
                    System.out.println("map1 " + temp);
                    map1.put(temp, map1.getOrDefault(temp, 0) + 1);
                }
            }
        }

        for(int i=0; i<str2.length() - 1; i++){
            if(str2.charAt(i) >= 'A' && str2.charAt(i)<='Z'){
                if(str2.charAt(i + 1) >= 'A' && str2.charAt(i + 1)<='Z'){
                    String temp = str2.charAt(i)+"";
                    temp += str2.charAt(i + 1);
                    System.out.println("map2 " + temp);
                    map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                }
            }
        }
        int inter = 0;
        int sum = 0;

        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            String key = entry.getKey();
            int cnt = entry.getValue();
            if(map2.containsKey(key)){
                inter += Math.min(map2.get(key), cnt);
                sum += Math.max(map2.get(key), cnt);
                System.out.println("getKey " + key);
                map2.remove(key);
            }else{
                sum += cnt;
            }
        }

        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            sum += entry.getValue();
        }

        if(inter == sum){
            answer = 1*65536;
            return answer;
        }

        if(inter == 0){
            return 0;
        }

        double JACADE = ((double)inter / sum);
        System.out.println(JACADE);
        answer = (int)(JACADE * 65536) ;

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("aa1+aa2", "AAAA12");
    }
}
