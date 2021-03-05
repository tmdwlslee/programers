package level3.day16;

public class P3 {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            if(A[i]/10 == 0){
                if(max < A[i])
                    max = A[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-10};
        solution(arr);
    }
}
