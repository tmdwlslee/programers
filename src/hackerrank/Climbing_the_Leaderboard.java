package hackerrank;

import java.util.*;

public class Climbing_the_Leaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<Integer>();

        for (int num : ranked) {
            if (!set.contains(num)) {
                stack.push(num);
                set.add(num);
            }
        }

        for (int num : player) {

            while (!stack.isEmpty()) {
                if (stack.peek() > num) {
                    answer.add(stack.size() + 1);
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty())
                answer.add(1);

        }

        return answer;

    }

}
