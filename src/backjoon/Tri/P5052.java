package backjoon.Tri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TrieNode{
    HashMap<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLast;

    public Map<Character,TrieNode> getChildNodes(){
        return childNodes;
    }

    public boolean isLast(){
        return isLast;
    }

    public void setLast(boolean last){
        isLast = last;
    }
}

class Trie{
    private TrieNode rootNode;

    public Trie() {
        this.rootNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            node = node.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        node.setLast(true);
    }

    public boolean contains(String word) {
        TrieNode node = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            TrieNode thisNode = node.getChildNodes().get(word.charAt(i));

            if (thisNode == null) {
                return false;
            }
            if(i < word.length() - 1 && thisNode.isLast()){
                return thisNode.isLast();
            }
            node = thisNode;
        }

        return node.isLast();
    }
}

public class P5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            Trie trie = new Trie();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<String> words = new ArrayList<>();
            boolean check = true;
            for (int j = 0; j < m; j++) {
                String word = br.readLine();
                words.add(word);
            }
            Collections.sort(words);
            for (int j = 0; j < m; j++) {
                String word = words.get(j);
                if (trie.contains(word)) {
                    check = false;
                }else{
                    trie.insert(word);
                }
            }
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
