package level2.day26;

import java.util.HashMap;
import java.util.Map;

public class 추석_트래픽 {
    public static int solution(String[] lines) {
        int answer = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            System.out.println("line[1] : "+ line[1]);
            String[] time = line[1].split(":");
            System.out.println("time[2] : "+ time[2]);
            String tempMs = time[2].substring(3);
            System.out.println("tempMs : 0"+tempMs);
            double ms = Double.parseDouble("0." + tempMs);
            ms += 0.001;
            System.out.println("ms " + ms);
            System.out.println("runningMs : "+line[2].substring(0,line[2].length() - 1));
            double runningMs = Double.parseDouble(line[2].substring(0,line[2].length() - 1));
            System.out.println("total : "+time[0] + time[1] + time[2].substring(0,2));
            long total = Long.parseLong(time[0] + time[1] + time[2].substring(0,2));

            int cnt = (int) (ms + runningMs);
            System.out.println("cnt : "+cnt);

            for (int j = 0; j <= cnt; j++) {
                map.put(total - j, map.getOrDefault(total - j, 0) + 1);
                System.out.println("total - j : "+(total - j));
            }
        }

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (answer < entry.getValue()) {
                answer = entry.getValue();
                System.out.println(entry.getKey());
            }
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        solution(lines);
    }
}
