package level2;

import java.util.HashSet;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int len = words.length;
        int cnt = 1;
        boolean check = true;
        HashSet<String> record = new HashSet<>();
        String preStr = words[0];

        record.add(preStr);

        for (int i = 1; i < len; i++) {
            if(i%n == 0) ++cnt;

            if (preStr.charAt(preStr.length() - 1) == words[i].charAt(0)) {
                if (!record.contains(words[i])) {
                    record.add(words[i]);
                    preStr = words[i];
                } else {
                    answer[0] = (i % n) + 1;
                    answer[1] = cnt;
                    break;
                }
            }else{
                answer[0] = (i % n) + 1;
                answer[1] = cnt;
                break;
            }
        }

        return answer;
    }
}
