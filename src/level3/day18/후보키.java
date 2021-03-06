package level3.day18;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키 {
    public static int answer = 0;
    public static int max = 0;
    public static void getAnswer(String[][] relation, boolean[] check, ArrayList<String> list, int cnt, int end, int index){
        if(cnt > 1){
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
                set.add(list.get(i));
            }
            if(set.size() == relation.length){
                //System.out.println("set.size() " + set.size());
                //System.out.println("relation.length " + relation.length);
                ++answer;
                System.out.println("ans " + answer);
                return;
            }
        }
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            temp.add(list.get(i));
        }

        for(int i=index + 1; i<relation[0].length; i++){
            if(!check[i]){
                check[i] = true;
                list = new ArrayList<>();
                for(int j=0; j<relation.length; j++){
                    if(temp.size() > 0){
                        list.add(temp.get(j) +"?" + relation[j][i]);
                    }else{
                        list.add(relation[j][i]);
                    }
                }
                getAnswer(relation, check, list, cnt + 1, relation.length, i);
                check[i] = false;
                list = new ArrayList<>();
                for(int j=0; j<temp.size(); j++){
                    list.add(temp.get(j));
                }
            }
        }
    }

    public static int solution(String[][] relation) {
        boolean[] check = new boolean[relation[0].length];
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<relation[0].length; i++){
            HashSet<String> set = new HashSet<>();
            for(int j=0; j<relation.length; j++){
                set.add(relation[j][i]);
            }
            if(set.size() == relation.length){
                ++answer;
                check[i] = true;
            }
        }

        for(int i=0; i<relation[0].length; i++){
            if(!check[i]){
                check[i] = true;
                for(int j=0; j<relation.length; j++){
                    list.add(relation[j][i]);
                }
                getAnswer(relation, check, list, 1, relation.length, i);
                check[i] = false;
                list = new ArrayList<>();
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[][] arr = {{"a","b","c"},{"1","b","c"},{"a","b","4"},{"a","5","c"}};
        //String[][] arr = {{"a","aa"},{"aa","a"},{"a","a"}};
        //String[][] arr = {{"100","ryan","music","2","1"},{"200","apeach","math","2","2"},{"300","tube","computer","3","3"},{"400","con","computer","4","4"},{"500","muzi","music","3","5"},{"600","apeach","music","2","5"}};
        solution(arr);
    }
}
