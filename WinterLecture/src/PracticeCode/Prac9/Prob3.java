package PracticeCode.Prac9;
import java.util.*;
public class Prob3 {
    //01 29
    public int solution(int[][] board) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = board.length;
        int m = board[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2] > dist[cur[0]][cur[1]]) continue;
            for(int k=0;k<4;k++){
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(board[nx][ny] == 0 && dist[nx][ny] > cur[2]){
                        dist[nx][ny] = cur[2];
                        pq.offer(new int[]{nx,ny,dist[nx][ny]});
                    }else if(board[nx][ny] == 1 && dist[nx][ny] > cur[2] + 1){
                        dist[nx][ny] = cur[2] + 1;
                        pq.offer(new int[]{nx,ny,dist[nx][ny]});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }

    public String change(String s){
        char[] tmp = s.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] == '[') tmp[i] = '{';
            if(tmp[i] == ']') tmp[i] = '}';
        }
        return String.valueOf(tmp);
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.change("[[0, 1, 1, 0], [1, 0, 1, 1], [0, 1, 0, 0]]"));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
    }
}
