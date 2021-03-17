package level2.day25;

public class 예상_대진표 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        a = Math.min(a, b);
        b = Math.max(a, b);

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            ++answer;
        }

        return answer;
    }
}
