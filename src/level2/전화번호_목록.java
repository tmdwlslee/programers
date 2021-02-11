package level2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new LinkedHashSet<>(); // 순서를 보장해주는 HashSet 사용

        for(int i=0; i<phone_book.length; i++){
            set.add(phone_book[i]);
        }

        int index = 0;
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String s = it.next();
            for(int i=0; i<phone_book.length; i++){
                if(i != index){
                    if(phone_book[i].startsWith(s)){ // 접두어로 사용된다면
                        answer = false;
                        return answer;
                    }
                }
            }
            ++index;
        }

        return answer;
    }
}
