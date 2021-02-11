package level2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cnt = 0;

        for(int i=0; i<prices.length; i++) {
            cnt = 0;
            for(int j=i+1; j<prices.length; j++) {
                ++cnt;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = cnt;
            //System.out.println(answer[i]);
        }
        return answer;
    }

}
