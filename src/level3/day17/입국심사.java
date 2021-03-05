package level3.day17;

public class 입국심사 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        long right = 1000000000l;
        long left = 0;

        while(left <= right){
            long mid = (left + right)/2;
            long cnt = 0;
            for(int i=0; i<times.length; i++){
                cnt += mid/times[i];
            }

            if(cnt >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] time = {7,10};
        solution(6, time);
    }
}
