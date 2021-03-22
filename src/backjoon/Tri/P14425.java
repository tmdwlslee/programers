package backjoon.Tri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//class TrieNode{
//    private HashMap<String, TrieNode> childNodes = new HashMap<>();
//    private boolean isLast;
//
//    public Map<String,TrieNode> getChildNodes(){
//        return childNodes;
//    }
//
//    public boolean isLast(){
//        return isLast;
//    }
//
//    public void setLast(boolean last){
//        isLast = last;
//    }
//}
//
//class Trie{
//    private TrieNode rootNode;
//
//    public Trie() {
//        this.rootNode = new TrieNode();
//    }
//
//    public void insert(String word){
//        TrieNode node = this.rootNode;
//
//        node = node.getChildNodes().computeIfAbsent(word, c->new TrieNode());
//
//        node.setLast(true);
//    }
//
//    public boolean contains(String word) {
//        TrieNode node = this.rootNode;
//
//        TrieNode thisNode = node.getChildNodes().get(word);
//        if (thisNode == null) {
//            return false;
//        }
//        node = thisNode;
//
//        return node.isLast();
//    }
//}

public class P14425 {  //문자열 집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (trie.contains(word)) {
                ++answer;
            }
        }
        System.out.println(answer);
    }
}
