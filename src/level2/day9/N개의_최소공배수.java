package level2.day9;

import java.util.LinkedList;
import java.util.Queue;

public class N개의_최소공배수 {
    public static long solution(int[] arr) {
        long answer = 0;
        Queue<Long> q = new LinkedList<>();
        for(int i=0; i<arr.length; i++){
            q.offer((long)arr[i]);
        }

        while (q.size() > 1){
            long a = q.poll();
            long b = q.poll();
            long gcd = getGCD(Math.max(a,b), Math.min(a,b));
            if(answer < a*b/gcd){
                answer = a*b/gcd;
            }
            q.offer(a*b/gcd);
        }
        return answer;
    }

    public static long getGCD(long n, long m) {
        if(m == 0) return n;
        return getGCD(m, n%m);
    }

    public static void main(String[] args) {
        int[] arr = new int[15];

        for(int i=0; i<15; i++){
            arr[i] = i+1;
        }

        System.out.println(solution(arr));
    }
}
