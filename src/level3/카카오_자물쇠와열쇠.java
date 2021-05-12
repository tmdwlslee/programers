package level3;

public class 카카오_자물쇠와열쇠 {

    public static void runRotate(int[][] key){

        int keyLen = key.length;
        int[][] temp = new int[keyLen][keyLen];

        // 임시 테이블에 저장
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                temp[i][j] = key[i][j];
            }
        }

        // 90도 회전
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                key[i][j] = temp[keyLen - 1 - j][i];
                //System.out.print(key[i][j] + " ");
            }
            //System.out.println();
        }
       // System.out.println();

        return;
    }

    public static boolean isValidation(int[][] totalBoard, int[][] key, int keyLen, int[][] lock, int lockLen, int x, int y){
        boolean isCheck = true;
        int[][] temp = new int[keyLen][keyLen];

        System.out.println("x = " + x + " y = " + y);
        System.out.println();
        // temp에 저장
        for (int i = x; i < x + keyLen; i++) {
            for (int j = y; j < y + keyLen; j++) {
                temp[i - x][j - y] = totalBoard[i][j];
                System.out.print(temp[i - x][j - y] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // totalBoard에 값 합산
        for (int i = x; i < x + keyLen; i++) {
            for (int j = y; j < y + keyLen; j++) {
                totalBoard[i][j] += key[i - x][j - y];
                System.out.print(totalBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // check
        for (int i = lockLen; i < 2*lockLen; i++) {
            if(!isCheck) break;
            for (int j = lockLen; j < 2*lockLen; j++) {
                if(totalBoard[i][j] != 1){
                    isCheck = false;
                }
            }
        }

        // 중앙 복원
        for (int i = lockLen; i < 2*lockLen; i++) {
            for (int j = lockLen; j < 2*lockLen; j++) {
                totalBoard[i][j] = lock[i - lockLen][j - lockLen];
            }
        }

        // 시작부분 복원
        for (int i = x; i < x + keyLen; i++) {
            for (int j = y; j < y + keyLen; j++) {
                totalBoard[i][j] = temp[i - x][j - y];
            }
        }

        return isCheck;
    }

    public static boolean rangeValidation(int x, int y, int totalLen, int keyLen) {
        if(x + keyLen >= 0 && x + keyLen < totalLen && y + keyLen >= 0 && y + keyLen < totalLen) return true;
        return false;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int lockLen = lock.length;
        int keyLen = key.length;
        int[][] totalBoard = new int[3 * lockLen][3 * lockLen];

        // 배열 정중앙에 위치
        for(int i=lockLen; i<2*lockLen; i++){
            for (int j = lockLen; j < 2 * lockLen; j++) {
                totalBoard[i][j] = lock[i - lockLen][j - lockLen];
            }
        }


        int totalLen = totalBoard.length;

        for (int i = 0; i < totalLen; i++) {
            for (int j = 0; j < totalLen; j++) {
                if(rangeValidation(i,j,totalLen,keyLen)) {
                    for (int k = 0; k < 4; k++) {
                        runRotate(key);
                        answer = isValidation(totalBoard, key, keyLen, lock, lockLen, i, j);
                        if(answer){
                            return answer;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] key = {{1,1,1}, {1,0,0}, {0,0,0}};
        int[][] lock = {{1,0,0,1},{1,0,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(solution(key, lock));

    }
}
