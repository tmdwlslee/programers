package level3.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 배달맨 {
    public static int row = 0;
    public static int col = 0;
    public static int n = 0;
    public static int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    static class Node{
        int x;
        int y;
        int depth;
        int next;

        public Node(int x, int y, int depth, int next) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.next = next;
        }
    }

    public static void initCheck(boolean[][] check, char[][] arr){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j] == '#') check[i][j] = true;
                else check[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        char[][] arr = new char[row][col];

        for(int i=0; i<row; i++){
            arr[i]= br.readLine().toCharArray();
        }

        int max = Integer.MAX_VALUE;
        boolean[][] check = new boolean[row][col];
        Queue<Node> startQ = new LinkedList<>();
        startQ.offer(new Node(0,0,0,0));

        while(!startQ.isEmpty()){
            Node node = startQ.poll();
            Queue<Node> q = new LinkedList<>();
            initCheck(check, arr);
            if(node.next == n){
                max = Math.min(node.depth, max);
                continue;
            }
            q.offer(node);
            while (!q.isEmpty()){
                Node qn = q.poll();
                boolean breakPoint = false;
                System.out.println("x " + qn.x + " dy " +qn.y + " depth " + qn.depth+ " next " + qn.next );
                if(arr[qn.x][qn.y] - '0' == qn.next + 1){
                    startQ.offer(new Node(qn.x, qn.y, qn.depth, qn.next + 1));
                    break;
                }
                for(int j=0; j<4; j++){
                    int dx = qn.x + d[j][0];
                    int dy = qn.y + d[j][1];
                    if(dx >=0 && dx < row && dy >= 0 && dy < col){
                        if(!check[dx][dy]){
                            check[dx][dy] = true;
                            System.out.println("arr[dx][dy] " + arr[dx][dy] );
                            if((arr[dx][dy] - '0') == qn.next + 1){
                                startQ.offer(new Node(dx, dy, qn.depth + 1, qn.next + 1));
                                System.out.println("start dx " + dx + " dy " +dy + " depth " + (qn.depth+1) + " next " + (qn.next+1) );
                                breakPoint = true;
                                break;
                            }else{
                                q.offer(new Node(dx, dy, qn.depth + 1, qn.next));
                            }
                        }
                    }
                }
                if(breakPoint) break;
            }
        }
        System.out.println(max+"회");
    }
}
