package level2.day8;

public class N진수게임 {
    public static char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder makeStr = new StringBuilder();

        int num = 0;
        while (t*m > makeStr.length()){
            makeStr.append(getJinsu(n, num));
            ++num;
        }

        int index = p-1;
        while (t > 0){
            System.out.println("char " + makeStr.charAt(index) + " index " +index);
            answer.append(makeStr.charAt(index));
            index += m;
            t--;
        }

        return answer.toString();
    }

    public static String getJinsu(int n, int num){
        StringBuilder result = new StringBuilder();

        if(num == 0) return result.append("0").toString();

        while (num > 0){
            result.insert(0  ,  arr[num % n]);
            num/= n;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        solution(2,4,2,1);
    }
}
