package level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] board = new int[n + 1][m + 1];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(0, 0));
        board[0][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.x == n - 1 && node.y == m - 1) {
                answer = board[node.x][node.y];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = node.x + d[i][0];
                int dy = node.y + d[i][1];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
                    if (maps[dx][dy] == 1) {
                        q.offer(new Node(dx, dy));
                        board[dx][dy] += (board[node.x][node.y] + 1);
                        maps[dx][dy] = 0;

                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        solution(a);
    }
}
