package level2.day13;

import java.util.ArrayList;
import java.util.Arrays;

public class 방금그곡 {
    static class Word{
        int index = 0;
        int total = 0;
        String word = "";

        public Word(int index, int total, String word) {
            this.index = index;
            this.total = total;
            this.word = word;
        }
    }

    public static String makeString(int cnt, String s){
        int mod = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(cnt > 0){
            if(s.charAt((i+1)%mod) == '#') {
                sb.append(s.charAt(i%mod) - 'A');
                i++;
            }else{
                sb.append(s.charAt(i%mod));
            }
            ++i;
            --cnt;
        }
        return sb.toString();
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        ArrayList<Word> list = new ArrayList<>();
        int cnt = 0;

        for(int i=0; i<m.length(); i++){
            if(m.charAt(i) == '#') ++cnt;
        }
        m = makeString(m.length()-cnt, m);

        System.out.println(m);

        int max = -1;
        for(int i=0; i< musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            System.out.println(info[0]);
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");

            int sTime = (Integer.parseInt(startTime[0])*60) + Integer.parseInt(startTime[1]);
            int eTime = (Integer.parseInt(endTime[0])*60) + Integer.parseInt(endTime[1]);
            int totalTime = eTime - sTime;
            System.out.println(totalTime);
            String make = makeString(totalTime, info[3]);
            System.out.println(make.length());
            StringBuilder sb = new StringBuilder(make);
            sb.append(make);

            if(sb.toString().contains(m)){
                if(max < totalTime){
                    max = totalTime;
                    answer = info[2];
                }
            }
        }

        if(answer.equals("")) answer = "(None)";
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String m = "A#B#C#";
        String[] info = {"00:00,23:59,HELLO,C#DEFGA#B#", "13:00,23:05,WORLD,A#B#C#DEF"};
        String[] info2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String[] info3 = {"12:50,13:04,HELLO,C#DEFGAB", "13:00,13:06,WORLD,ABC#ABC"};
        String[] info4 = {"22:48,23:49,HELLO,C#C#C#C#C#C#C#", "13:00,13:05,WORLD,AB#CDEF"};
        solution(m, info);
    }
}
