package level3.day19;

public class 등굣길 {
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n + 1][m + 1];
        boolean[][] check = new boolean[n + 1][m + 1];

        for(int i=0; i<puddles.length; i++){
            check[puddles[i][1]][puddles[i][0]] = true;
        }
        arr[1][1] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(!check[i - 1][j]) arr[i][j] += arr[i-1][j];
                if(!check[i][j-1]) arr[i][j] += arr[i][j-1];
                arr[i][j] %= 1000000007;
            }
        }

        return arr[n][m];
    }

    public static void main(String[] args) {
        int[][] p = {{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}};
        solution(7, 4, p);
    }
}
