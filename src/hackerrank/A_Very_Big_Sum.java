package hackerrank;

import java.math.BigInteger;

public class A_Very_Big_Sum {
    static long aVeryBigSum(long[] ar) {
        long answer = 0;
        for (int i = 0; i < ar.length; i++) {
            answer += ar[i];
        }

        return answer;
    }
}
