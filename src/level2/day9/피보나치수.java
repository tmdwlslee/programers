package level2.day9;

public class 피보나치수 {
    public int solution(int n) {
        int[] dp = new int[100001];
        dp[1] = 1;

        for(int i=2; i<=100000; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
