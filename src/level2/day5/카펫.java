package level2.day5;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int width = 0;
        int height = 0;

        for(int i=1; i<=brown; i++) { // i : 가로, sum/i 세로
            if(sum/i > 0 && sum%i == 0) {
                if(((sum/i)-2)*(i-2) == yellow){
                    if(i >= sum/i) {
                        width = i;
                        height = sum/i;
                    }
                }
            }
        }
        answer[0] = width;
        answer[1] = height;

        return answer;
    }
}
