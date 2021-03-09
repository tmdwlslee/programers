package level3.day20;

import java.util.*;

public class 베스트앨범 {
    static class Album{
        int index;
        int cnt;

        public Album(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> indexList = new ArrayList<>();
        int[] answer = {};
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1,o2)->o2.getValue()-o1.getValue());
        int index = 0;
        for(Map.Entry<String,Integer> entry : list){
            String genre = entry.getKey();
            ArrayList<Album> playList = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genre.equals(genres[i])){
                    playList.add(new Album(i,plays[i]));
                }
            }

            Collections.sort(playList, (p1, p2)->p2.cnt - p1.cnt);
            for(int i=0; i<playList.size(); i++){
                if(i < 2){
                    indexList.add(playList.get(i).index);
                }
            }
        }
        answer = new int[indexList.size()];

        for(int i=0; i< answer.length; i++){
            answer[i] = indexList.get(i);
        }

        return answer;
    }
}
