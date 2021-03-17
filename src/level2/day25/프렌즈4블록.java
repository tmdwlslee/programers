package level2.day25;

public class 프렌즈4블록 {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            char[] temp = board[i].toCharArray();
            for(int j=0; j<temp.length; j++){
                arr[i][j] = (temp[j] - 'A') + 1;
            }
        }

        while (true) {
            int cnt = 0;
            boolean[][] check = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    int num = arr[i][j];
                    if(num > 0 && arr[i + 1][j] == num){
                        if (arr[i][j + 1] == num) {
                            if (arr[i + 1][j + 1] == num) {
                                check[i][j] = true;
                                check[i + 1][j] = true;
                                check[i][j + 1] = true;
                                check[i + 1][j + 1] = true;
                            }
                        }
                    }
                }
            }

          for(int i=0; i<m; i++){
              for (int j = 0; j < n; j++) {
                   if (check[i][j]) {
                       arr[i][j] = 0;
                       ++cnt;
                    }
                }
            }

            System.out.println();

            for(int i=0; i<m; i++){
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i > 0; i--) {
                    if(arr[i][j] == 0){
                        for(int k = i - 1; k>=0; k--){
                            if(arr[k][j] > 0){
                                arr[i][j] = arr[k][j];
                                arr[k][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println();

            for(int i=0; i<m; i++){
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("cnt " + cnt);

            if(cnt == 0) break;

            answer += cnt;
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        String[] str = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        solution(6,6, str);
    }
}
