package level2;

public class 행렬테두리회전하기 {
    public static int min;

    public void right(int[][] temp, int[][] arr, int x1, int y1, int x2, int y2){
        for(int i=y1 + 1; i<=y2; i++){
            arr[x1][i] = temp[x1][i - 1];
            if(arr[x1][i] < min)
                min = arr[x1][i];
        }
    }

    public void down(int[][] temp, int[][] arr, int x1, int y1, int x2, int y2){
        for(int i=x1+1; i<=x2; i++){
            arr[i][y2] = temp[i - 1][y2];
            if(arr[i][y2] < min)
                min = arr[i][y2];
        }
    }

    public void left(int[][] temp, int[][] arr, int x1, int y1, int x2, int y2){
        for (int i = y2-1; i >= y1; i--) {
            arr[x2][i] = temp[x2][i + 1];
            if(arr[x2][i] < min)
                min = arr[x2][i];
        }
    }

    public void up(int[][] temp, int[][] arr, int x1, int y1, int x2, int y2){
        for (int i = x2 - 1; i >= x1; i--) {
            arr[i][y1] = temp[i + 1][y1];
            if(arr[i][y1] < min)
                min = arr[i][y1];
        }
    }

    public void copy(int[][] temp, int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
    }

    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] arr = new int[rows][columns];
        int[][] temp = new int[rows][columns];
        int start = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = start;
                temp[i][j] = start;
                start++;
            }
        }

        int len = queries.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            min = Integer.MAX_VALUE;

            right(temp, arr, x1,y1,x2,y2);
            down(temp, arr, x1,y1,x2,y2);
            left(temp, arr, x1,y1,x2,y2);
            up(temp, arr, x1,y1,x2,y2);

            answer[i] = min;

            copy(temp, arr);
        }
        return answer;
    }
}
