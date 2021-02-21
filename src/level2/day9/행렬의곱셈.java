package level2.day9;

public class 행렬의곱셈 {
    public static int getNum(int[][] arr1, int[][] arr2, int row, int col){
        int num = 0;

        for(int i=0; i<arr1[0].length; i++){
            num += (arr1[row][i] * arr2[i][col]);
        }

        return num;
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int width = arr1.length;
        int height = arr2[0].length;
        int[][] answer = new int[width][height];

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                answer[i][j] = getNum(arr1, arr2, i, j);
            }
        }
        return answer;
    }
}
