package level2.day4;

import java.util.LinkedList;
import java.util.Queue;

public class 땅따먹기 {

    int solution(int[][] land) {
        int answer = 0;
        int end = land.length - 1;
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++){
                if(j == 0){
                    land[i][j] = Math.max(Math.max(land[i-1][1] + land[i][j], land[i-1][2] + land[i][j]), land[i-1][3] + land[i][j]);
                }else if(j == 1){
                    land[i][j] = Math.max(Math.max(land[i-1][0] + land[i][j], land[i-1][2] + land[i][j]), land[i-1][3] + land[i][j]);
                }else if(j == 2){
                    land[i][j] = Math.max(Math.max(land[i-1][1] + land[i][j], land[i-1][0] + land[i][j]), land[i-1][3] + land[i][j]);
                }else{
                    land[i][j] = Math.max(Math.max(land[i-1][1] + land[i][j], land[i-1][2] + land[i][j]), land[i-1][0] + land[i][j]);
                }
            }
        }

        for(int i=0; i<4; i++){
            answer = Math.max(land[end][i], answer);
        }

        return answer;
    }
}
