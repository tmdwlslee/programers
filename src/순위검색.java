import java.util.*;

class TrieNode{
    private Map<String,TrieNode> childNodes = new HashMap<>();
    private boolean isLast;
    //private String word;

    public Map<String, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}

class Trie{
    private TrieNode rootNode;
    private int score;

    public Trie() {
        this.rootNode = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = this.rootNode;
        String[] arr = word.split(" ");

        int cnt = 1;
        for(int i=0; i<arr.length-1; i++){
            node = node.getChildNodes().computeIfAbsent(arr[i], c->new TrieNode());
        }
        score = Integer.parseInt(arr[4]);
        node.setLast(true);
    }

    boolean contains(String[] arr){
        TrieNode node = this.rootNode;
        String[][] check = {{"cpp", "java", "python"},{"backend", "frontend"},{"junior", "senior"},{"chicken", "pizza"}};
        for(int i=0; i<arr.length-1; i++){
            if(arr[i].equals("-")){
                TrieNode thisNode = null;
                Set<String> set = node.getChildNodes().keySet();

                for(String s : set){
                    thisNode = node.getChildNodes().get(s);
                }

                if(thisNode == null){
                    return false;
                }

                node = thisNode;

            }else{
                TrieNode thisNode = node.getChildNodes().get(arr[i]);

                if(thisNode == null){
                    //System.out.println("null");
                    return false;
                }
                //System.out.println(thisNode.getWord());
                node = thisNode;
            }

        }

        return node.isLast();
    }

    public int getScore() {
        return score;
    }
}

public class 순위검색 {

    public static int getIndex(Trie[] tries, int score){
        int first = 0;
        int last = tries.length - 1;
        int mid = 0;

        while (first < last){
            mid = (first + last)/2;

            if(tries[mid].getScore() >= score ){
                last = mid;
            }else{
                first = mid+1;
            }
        }
        return last;
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Trie[] trie = new Trie[info.length];

        for(int i=0; i<trie.length; i++){
            trie[i] = new Trie();
            trie[i].insert(info[i]);
        }

        Arrays.sort(trie, (t1,t2)->t1.getScore()-t2.getScore());

        for(int j=0; j<query.length; j++){
            int cnt = 0;
            String temp = query[j].replaceAll("and ", "");
            String[] arr = temp.split(" ");

            //System.out.println("find score : " + arr[4]);
            int mid = getIndex(trie, Integer.parseInt(arr[4]));

            //System.out.println("mid : " + mid);

            for(int k=mid; k<trie.length; k++){
                if(Integer.parseInt(arr[4]) <= trie[k].getScore()){
                    if(trie[k].contains(arr)){
                        cnt++;
                    }
                }
            }

            answer[j] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] result = solution(info, query);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
