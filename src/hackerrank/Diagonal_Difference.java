package hackerrank;

import java.util.List;

public class Diagonal_Difference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int left = 0;
        int right = 0;
        int end = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++, end--) {
            left += arr.get(i).get(i);
            System.out.println("left " + arr.get(i).get(i));
            right += arr.get(end).get(i);
            System.out.println("right " + arr.get(end).get(i));
        }

        return Math.abs(left - right);

    }

}
