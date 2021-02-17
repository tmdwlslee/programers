package level2.day7;

public class 가장_큰_정사각형 {
    public int solution(int [][]board)
    {
        int answer = 0;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int leftUp = 0;
                int left = 0;
                int up = 0;
                if(i - 1 >= 0 && j - 1 >= 0){
                    leftUp = board[i - 1][j - 1];
                }
                if(i - 1 >= 0){
                    up = board[i - 1][j];
                }
                if(j - 1 >= 0){
                    left = board[i][j - 1];
                }

                if(board[i][j] == 0){
                    board[i][j] = 0;
                }else{
                    board[i][j] = Math.min(left,Math.min(leftUp, up)) + 1;
                }
                answer = Math.max(answer, board[i][j]);
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        return answer*answer;
    }
}
