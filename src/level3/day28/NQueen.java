package level3.day28;

public class NQueen {
    public static boolean[] checkCol;
    public static boolean[] checkLeftDir;
    public static boolean[] checkRightDir;
    public boolean check(int row, int col) {

        if(checkCol[col]) return false;
        if(checkLeftDir[row + col]) return false;
        if(checkRightDir[Math.abs(row - col)]) return false;

        return true;
    }

    public int putQueen(int row, int n){
        int cnt = 0;
        if(row == n){
            return 1;
        }else{
            for (int i = 0; i < n; i++) {
                if (check(row, i)) {
                    checkCol[i] = true;
                    checkLeftDir[row + i] = true;
                    checkRightDir[Math.abs(row - i)] = true;
                    cnt += putQueen(row + 1, n);
                    checkCol[i] = false;
                    checkLeftDir[row + i] = false;
                    checkRightDir[Math.abs(row - i)] = false;
                }
            }
        }
        return cnt;
    }

    public int solution(int n) {
        int answer = 0;

        checkCol = new boolean[n + 1];
        checkLeftDir = new boolean[2 * n + 1];
        checkRightDir = new boolean[2 * n + 1];
        answer = putQueen(0, n);

        return answer;
    }
}
