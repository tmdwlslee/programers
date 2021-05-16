package backjoon.stack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class P_5397 { // 문제 5397 : 키로거
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        Deque<Character> preStack = new ArrayDeque<>();
        Deque<Character> postStack = new ArrayDeque<>();


        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int len = s.length();

            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);
                if(c == '<'){
                    if(!postStack.isEmpty()){
                        preStack.push(postStack.pop());
                    }
                }else if(c == '>'){
                    if(!preStack.isEmpty()){
                        postStack.push(preStack.pop());
                    }
                }else if (c == '-') {
                    if(!postStack.isEmpty()) postStack.pop();
                }else{
                    postStack.push(c);
                }
            }

            while(!preStack.isEmpty()){
                postStack.push(preStack.pop());
            }

            while (!postStack.isEmpty()) {
                bw.write(postStack.pop());
            }

            bw.flush();

        }
        bw.close();
        br.close();
    }
}
