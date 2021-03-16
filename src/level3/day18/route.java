package level3.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class route {
    public static int answer = Integer.MAX_VALUE;

    public static void getAnswer(int[][] dist, ArrayList<Integer> arr, int index, int end){
        if(arr.size() == end){
            int[] route = new int[dist.length];
            int row = arr.get(0);
            for(int i=0; i<route.length; i++){
                route[i] = dist[row][i];
            }

            for(int i=1; i<arr.size(); i++){
                row = arr.get(i);
                for(int j=0; j<dist.length; j++){
                    route[j] = Math.min(route[j], dist[row][j]);
                }
            }

            int max = 0;
            for(int i=0; i<route.length; i++){
                max = Math.max(route[i], max);
            }

            answer = Math.min(max, answer);
            return;
        }

        for(int i=index; i<dist.length; i++){
            arr.add(i);
            getAnswer(dist, arr, i+1, end);
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
                if(i!=j && dist[i][j] == 0){
                    dist[i][j] = 100000000;
                }
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        getAnswer(dist, arr, 0 ,  cnt);

        System.out.println(answer+" us");

    }
}
