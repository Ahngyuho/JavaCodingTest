package realCode.Prac11;
import java.util.*;
public class Prob2 {
    int solution(int[][] board,int[] s,int[] e){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] - b[2]));
        pq.offer(new int[]{s[0],s[1],0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            for(int k = 0; k < 4; k++) {
                int cnt = 0;
                int nx = cur[0];
                int ny = cur[1];
                while(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                    nx += dx[k];
                    ny += dy[k];
                    cnt++;
                }
                nx -= dx[k];
                ny -= dy[k];
                cnt--;
                if(nx == e[0] && ny == e[1]) return cur[2] + cnt;
                if(!visited[nx][ny]){
                    pq.offer(new int[]{nx,ny,cur[2] + cnt});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0,
                1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}},new int[]{1,0},new int[]{4,5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0,
                1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}},new int[]{0,0},new int[]{4,2}));
    }
}
