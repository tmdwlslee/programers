package level3;

public class 스티커모으기2 {
    public int solution(int sticker[]) {
        int answer = 0;

        int[] dp = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for(int i=2; i<dp.length - 1; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
            System.out.println(dp[i]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<dp.length; i++){
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
            System.out.println(dp2[i]);
        }

        answer = Math.max(dp[sticker.length - 1], dp2[sticker.length - 1]);

        return answer;
    }

    public static void main(String[] args) {

    }
}
