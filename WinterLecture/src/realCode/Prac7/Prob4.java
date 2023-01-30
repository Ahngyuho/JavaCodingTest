package realCode.Prac7;
import java.util.*;
public class Prob4 {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        int n = board.length;
        int[][] dist = new int[n][n];
        int emtLand = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1){
                    answer = Integer.MAX_VALUE;
                    Queue<int[]> Q  = new LinkedList<>();
                    Q.offer(new int[]{i,j});
                    int L = 0;
                    while(!Q.isEmpty()){
                        L++;
                        int len = Q.size();
                        for(int r = 0;r<len;r++){
                            int[] cur = Q.poll();
                            for(int k=0;k<4;k++){
                                int nx = dx[k] + cur[0];
                                int ny = dy[k] + cur[1];
                                if(nx >=0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emtLand){
                                    board[nx][ny]--;
                                    Q.offer(new int[]{nx,ny});
                                    dist[nx][ny] += L;
                                    answer = Math.min(answer,dist[nx][ny]);
                                }
                            }
                        }
                    }
                    emtLand--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0},
                {0, 0, 1, 2},
                {0, 2, 0, 0},
                {0, 2, 1, 0}}));
    }
}
