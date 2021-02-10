package level2;

public class 조이스틱 {
    public static int solution(String name) {
        int answer = 0;
        int cnt = name.length();
        int alpha = 0;
        int index = 0;
        for(int i=0; i<cnt; i++ ){ // 가장 적은 경우의 수로 알파벳을 만든다.
            if(name.charAt(i) != 'A') {
                int up = name.charAt(i) - 'A';
                int down = ('Z' - name.charAt(i)) + 1;
                answer += Math.min(up, down);
                ++alpha;
            }
        }

        int back = 0;
        index = name.charAt(0) == 'A' ? 1 : 0; // 첫 글자가 A인 경우에 바로 커서를 문자열 마지막에 넣으면 최단 경로가 아닐 수 있다.
        for(int i=index; i<name.length(); i++){ // 오른쪽으로 커서가 움직일 떄
            if(name.charAt(i) == 'A'){ // A를 만나면 문자열 맨 뒤로 이동
                if(i > 0) back += (i-1);
                index = i;
                break;
            }else{ // A가 아니라면 알파벳 cnt 1 감소
                --alpha;
                if(i > 0) ++back;
                if(alpha == 0) break;
            }
        }
        for(int i=name.length()-1; i>index; i--){ // 문자열 마지막에서 부터 알파벳 check
            if(alpha == 0) break;
            if(name.charAt(i) != 'A') --alpha;
            ++back;
        }

        System.out.println("back " + back);

        answer = Math.min(answer + name.length() - 1, answer + back); // 오른쪽으로만 이동했을 때와 A를 만나서 문자열 마지막로 넘어간 후 
                                                                      // 경로의 길이를 비교하여 가장 짧은 것을 선택               
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("AAA"));
    }
}
