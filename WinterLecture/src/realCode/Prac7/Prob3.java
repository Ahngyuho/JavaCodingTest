package realCode.Prac7;
import java.util.*;
public class Prob3 {
    public int solution(int[][] board) {
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        Queue<int[]> Q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        Q.offer(new int[]{0,0});
        int L = 0;
        while(!Q.isEmpty()){
            L++;
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] cur = Q.poll();
                for(int k=0;k<4;k++){
                    int nx = dx[k] + cur[0];
                    int ny = dy[k] + cur[1];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        Q.offer(new int[]{nx,ny});
                        dist[nx][ny] = L;
                    }
                }
            }
        }
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(new int[][]
                {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]
                {{0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 1, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {1, 1, 0, 1, 1, 1, 1},
                        {1, 1, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 1, 0, 0}}));
    }
}
