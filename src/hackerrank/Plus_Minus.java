package hackerrank;

public class Plus_Minus {
    static void plusMinus(int[] arr) {
        int negative = 0;
        int positive = 0;
        int zero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negative++;
            } else if (arr[i] > 0) {
                positive++;
            } else {
                zero++;
            }
        }

        System.out.println((float)positive/arr.length);
        System.out.println((float)negative/arr.length);
        System.out.println((float)zero/arr.length);
    }
}
