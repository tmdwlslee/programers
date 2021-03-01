package level3.day15;

import java.util.*;

public class 여행경로 {
    public static HashSet<String> set = new HashSet<>();

    public static void getAnswer(String[][] tickets, boolean[] check, String start, String route, int cnt, int size){
        if(cnt == size){
            set.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            String temp = tickets[i][0];
            if(!check[i]){
                if(temp.equals(start)){
                    check[i] = true;
                    getAnswer(tickets, check, tickets[i][1], route+tickets[i][1], cnt+1, size);
                    check[i] = false;
                }
            }
        }
    }
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] check = new boolean[tickets.length];
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();

        for(int i=0; i<tickets.length; i++){
            start.add(tickets[i][0]);
            end.add(tickets[i][1]);
        }

        int size = tickets.length;

        for(int i=0; i<tickets.length; i++){
            String temp = tickets[i][0];
            if(temp.equals("ICN")){
                getAnswer(tickets, check, "ICN", "ICN" , 0, size);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);

        String route = list.get(0);
        list = new ArrayList<>();
        for(int i=0; i<route.length()-2; i+=3){
            list.add(route.substring(i, i+3));
        }
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] arr = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        solution(arr);
    }
}
