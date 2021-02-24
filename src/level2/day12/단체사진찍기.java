package level2.day12;

public class 단체사진찍기 {

    public static int answer = 0;

    public static boolean checkCondition(int range, char check, int checkNum){
        if(check == '>'){
            return range > checkNum ? true : false;
        }else if(check == '<'){
            return range < checkNum ? true : false;
        }else{
            return range == checkNum ? true : false;
        }
    }

    public static int getIndex(char c){
        if(c == 'A'){
            return 1;
        }else if(c == 'C'){
            return 2;
        }else if(c == 'F'){
            return 3;
        }else if(c == 'J'){
            return 4;
        }else if(c == 'M'){
            return 5;
        }else if(c == 'N'){
            return 6;
        }else if(c == 'R'){
            return 7;
        }else{
            return 8;
        }
    }

    public static boolean checkArray(int[] arr, String[] data){

        for(int i=0; i<data.length; i++){
            int left = getIndex(data[i].charAt(0));
            int right = getIndex(data[i].charAt(2));
            char check = data[i].charAt(3);
            int checkNum = data[i].charAt(4) - '0';
            int lIdx = 0;
            int rIdx = 0;
            for(int j=0; j<arr.length; j++){
                if(arr[j] == left) lIdx = j;
                else if(arr[j] == right) rIdx = j;
            }
            int range = Math.abs(lIdx - rIdx);
            if(!checkCondition(range, check, checkNum + 1)){
                return  false;
            }
        }
        return true;
    }
    public static void getAnswer(int[] arr, int depth, int n, int r, String[] data){
        if(depth == r - 1){
            if(checkArray(arr, data)) ++answer;
            return;
        }

        for(int i=depth; i<n; i++){
            swap(arr,depth,i);
            getAnswer(arr, depth+1, n, r, data);
            swap(arr,depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static int solution(int n, String[] data) {
        answer = 0;
        int[] arr = {1,2,3,4,5,6,7,8};

        getAnswer(arr, 0, 8, 8, data);

        return answer;
    }

    public static void main(String[] args) {
        String[] s = {"N~F=0", "R~T>2"};
        solution(2,s);
    }
}
