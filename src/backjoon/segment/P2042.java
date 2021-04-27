package backjoon.segment;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class P2042 {

    public static long init(long[] arr, long[] tree, int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }else{
            return tree[node] = (init(arr, tree, 2 * node, start, (start + end) / 2) + init(arr, tree, 2 * node + 1, (start + end) / 2 + 1, end));
        }
    }

    public static long sum(long[] tree, int node, int start, int end, int left, int right){
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        return sum(tree, node * 2, start, (start + end) / 2, left, right) + sum(tree, 2 * node + 1, (start + end) / 2 + 1, end, left, right);
    }

    public static void update(long[] tree, int node, int start, int end, int index, long diff){
        if(index < start || index > end) return;
        tree[node] = tree[node] + diff;
        if(start != end){
            update(tree, node*2, start, (start+end)/2, index, diff);
            update(tree, node*2 + 1, (start+end)/2 + 1, end, index, diff);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long[] tree = new long[4*n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(arr, tree, 1, 0, n-1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                // 원소 변경
                int b = Integer.parseInt(st.nextToken()) - 1;
                long c = Long.parseLong(st.nextToken());
                long diff = c - arr[b];
                arr[b] = c;
                update(tree, 1, 0, n-1, b, diff);

            }else{
                // 합구하기
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                bw.write(sum(tree, 1, 0, n -1, b, c) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
