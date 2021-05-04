package level3;

public class 거스름돈 {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        int len = money.length;
        for(int i=0; i<len; i++){
            for (int j = 1; j <= n; j++) {
                if (j >= money[i]) {
                    dp[j] += dp[j - money[i]];
                    dp[j] %= 1000000007;
                }
            }
        }

        return dp[n];
    }
}
