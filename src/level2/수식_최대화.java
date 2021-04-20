package level2;

import java.util.ArrayList;

public class 수식_최대화 {
    public static long answer = 0;

    public static void cal(int[] order, String s) {
        String[] check = {"+", "-", "*"};
        String[] numbers = s.split("[*+-]");
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<String> gihos = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            //System.out.println(numbers[i]);
            nums.add(Long.parseLong(numbers[i]));
        }

        String[] giho = s.replaceAll("[0-9]", "").split("");
        for (int i = 0; i < giho.length; i++) {
            //System.out.println(giho[i]);
            gihos.add(giho[i]);
        }

        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < gihos.size(); j++) {
                if (gihos.get(j).equals(check[order[i]])) {
                    long a = nums.get(j);
                    long b = nums.get(j + 1);

                    if (order[i] == 0) {
                        nums.set(j, a + b);
                        nums.remove(j + 1);
                    } else if (order[i] == 1) {
                        nums.set(j, a - b);
                        nums.remove(j + 1);
                    } else{
                        nums.set(j, a * b);
                        nums.remove(j + 1);
                    }

                    gihos.remove(j);
                    j--;

                }
            }
        }

        long result = Math.abs(nums.get(0));

        if (answer < result) {
            answer = result;
        }

    }

    public static void getAnswer(int[] order, String s, int depth, int cnt) {
        if (cnt == 3) {
            cal(order, s);
            return;
        }

        for (int i = depth; i < 3; i++) {
            swap(order, depth, i);
            getAnswer(order, s, depth + 1, cnt + 1);
            swap(order, depth, i);
        }
    }

    public static void swap(int[] order, int depth, int x) {
        int temp = order[depth];
        order[depth] = order[x];
        order[x] = temp;
    }

    public static long solution(String expression) {
        int[] order = new int[3];

        for (int i = 0; i < 3; i++) {
            order[i] = i;
        }

        getAnswer(order, expression, 0, 0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }
}
