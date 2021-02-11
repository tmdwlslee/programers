package level2;

public class 소수찾기 {
    public static int[] check = new int[10000000];
    public static int answer = 0;

    public static void getAnswer(StringBuffer sb, String numbers, boolean[] numCheck, int cnt, int size){
        if(cnt > 0){
            if(check[Integer.parseInt(sb.toString())] == 0){
                System.out.println(sb.toString());
                ++answer;
                check[Integer.parseInt(sb.toString())] = -1;
                return;
            }
        }

        for(int i=0; i<size; i++){
            if(!numCheck[i]){
                sb.append(numbers.charAt(i));
                numCheck[i] = true;
                getAnswer(sb,numbers,numCheck,cnt+1,size);
                numCheck[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public int solution(String numbers) {

        int range = (int)Math.sqrt(10000000);
        int size = numbers.length();
        boolean[] numCheck = new boolean[size];
        check[0] = check[1] = 1;
        for(int i=2; i<range; i++){
            if(check[i] == 0){
                for(int j=i+i; j<10000000; j+=i){
                    check[j] = 1;
                }
            }
        }

        getAnswer(new StringBuffer(), numbers, numCheck,0,size);

        return answer;
    }
}
