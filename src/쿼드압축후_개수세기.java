public class 쿼드압축후_개수세기 {

    public static boolean checkSqare(int[][] arr, boolean[][] check, int x, int y, int width, int range){
        boolean[][] temp = new boolean[width][width];
        for(int i=0; i<width; i++){
            System.arraycopy(check[i],0,temp[i], 0, width);
        }
        boolean sameCheck = true;
        int num = arr[x][y];
        for(int i=x; i<x+range; i++){
            for(int j=y; j<y+range; j++){
                if(num ==arr[i][j]){
                    check[i][j] = true;
                }else{
                    sameCheck = false;
                    break;
                }
            }
        }

        if(sameCheck){
            return sameCheck;
        }else{
            for(int i=0; i<width; i++){
                System.arraycopy(temp[i],0,check[i], 0, width);
            }
            return sameCheck;
        }

    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int width = arr.length;
        int height = arr.length;
        boolean[][] check = new boolean[width][height];
        
        int range = width/2;
        while(range > 1){
            for(int i=0; i<width; i+=range){
                for(int j=0; j<height; j+=range){
                    System.out.println("i : "+ i + " j : "+ j);
                    if(check[i][j] == false){
                        if(checkSqare(arr,check,i,j,width,range)){
                            if(arr[i][j] == 0){
                                answer[0]++;
                            }else{
                                answer[1]++;
                            }
                        }
                    }
                }
            }
            range/=2;
        }

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                if(!check[i][j]) answer[arr[i][j]]++;
            }
        }

        return answer;
    }
        public static void main(String[] args) {
            int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
            int[] answer = solution(arr);

    }
}
