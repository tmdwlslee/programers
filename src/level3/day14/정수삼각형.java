package level3.day14;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i=0; i<triangle.length - 1; i++){
            for(int j=0; j<triangle[i + 1].length; j++){
                if(j == 0){
                    triangle[i + 1][j] += triangle[i][0];
                }else if(j == triangle[i].length - 1){
                    triangle[i + 1][j] += triangle[i][triangle[i].length - 1];
                }else{
                    triangle[i + 1][j] = Math.max(triangle[i + 1][j] + triangle[i][j - 1], triangle[i + 1][j] + triangle[i][j]);
                }
            }
        }
        int lastRow = triangle.length - 1;
        for(int i=0; i<triangle[lastRow].length; i++){
            System.out.println(triangle[lastRow][i]);
            if(answer < triangle[lastRow][i])
                answer = triangle[lastRow][i];
        }

        return answer;
    }
}
