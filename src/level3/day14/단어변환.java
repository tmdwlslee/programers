package level3.day14;

public class 단어변환 {
    public static int answer;

    public static boolean compareString(String begin, String target){
        boolean check = true;
        int cnt = 0;
        for(int i=0; i<begin.length(); i++){
            if(!(begin.charAt(i) == target.charAt(i))){
                ++cnt;
            }
        }
        if(cnt > 1) check = false;

        return check;
    }

    public static void getAnswer(String begin, String target, String[] words, boolean[] check, int cnt){
        if(begin.equals(target)){
            if(cnt < answer){
                answer = cnt;
            }
            return;
        }

        for(int i=0; i<words.length; i++){
            if(!check[i]){
                if(compareString(begin, words[i])){
                    check[i] = true;
                    getAnswer(words[i], target, words, check, cnt + 1);
                    check[i] = false;
                }
            }
        }

        return;
    }


    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        boolean isStrat = false;
        boolean[] check = new boolean[words.length];

        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                isStrat = true;
            }
        }

        if(isStrat){
            getAnswer(begin, target, words, check, 0);
        }

        if(answer == Integer.MAX_VALUE) answer = 0;

        return answer;
    }
}
