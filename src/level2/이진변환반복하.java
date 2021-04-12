package level2;

public class 이진변환반복하 {
    public static int zero = 0;
    public static int cnt = 0;

    public static String getMake(int num) {
        String s = "";

        while (num > 0) {
            s = (num % 2) + s;
            num /= 2;
        }

        return s;
    }

    public static void getCnt(String s) {
        if(s.equals("1")) return;

        int len = s.length();
        s = s.replaceAll("0", "");
        zero += (len - s.length());
        len = s.length();

        ++cnt;
        String makeStr = getMake(len);

        getCnt(makeStr);

        return;
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        getCnt(s);
        answer[0] = cnt;
        answer[1] = zero;

        return answer;
    }
}
