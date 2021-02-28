package level3.day14;

public class 타일링2xn{
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=60000; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }

        return dp[n];
    }
}
