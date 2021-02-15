package level2.day5;

public class 타겟넘버 {
    public static int answer = 0;

    public static void getAnswer(int[] numbers, int target, int index, int sum) {

        if(index == numbers.length ) {
            if(sum == target) {
                ++answer;
            }
            return;
        }

        getAnswer(numbers, target, index + 1, sum + numbers[index]);
        getAnswer(numbers, target, index + 1, sum - numbers[index]);
    }
}
