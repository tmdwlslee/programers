package level2.day4;

import java.util.ArrayList;
import java.util.Collections;

public class 구명보트 { // 효율성 0점, 개선해야함.

    public static int solution(int[] people, int limit) {
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;

        for (int i=0; i<people.length; i++){
            list.add(people[i]);
        }

        int size = list.size();
        Collections.sort(list);
        boolean[] check = new boolean[size];
        for(int i=0; i<size; i++){
            if(!check[i]){
                check[i] = true;
                int first = list.get(i);
                int start = i;
                int end = size - 1;
                int mid = 0;
                while(end > start){
                    mid = (start + end)/2;
                    if(!check[mid]){
                        if(list.get(mid) > limit - first){
                            end = mid;
                        }else{
                            start = mid + 1;
                        }
                    }else{
                        --end;
                    }
                }
                if(end > 0){
                    check[end - 1] = true;
                    if(end - 1 > size/2){
                        --size;
                    }
                }
                ++answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {70,50,50,80};
        System.out.println(solution(arr, 100));
    }
}
