package realCode.Prac4.Prac7;

import java.util.*;

public class Prob5 {
    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};
    int solution(int[][] board){
        Queue<Point> Q = new LinkedList<>();
        int n = board.length;
        int m = board[1].length;
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    int[][] ch = new int[n][m];
                    int L = 0;
                    Q.offer(new Point(i, j));
                    ch[i][j] = 1;
                    while (!Q.isEmpty()) {
                        L++;
                        int len = Q.size();
                        for (int k = 0; k < len; k++) {
                            Point p = Q.poll();
                            for (int z = 0; z < 4; z++) {
                                int ddx = dx[z] + p.x;
                                int ddy = dy[z] + p.y;
                                if (ddx >= 0 && ddx < n && ddy >= 0 && ddy < m && board[ddx][ddy] != 1 && ch[ddx][ddy] == 0) {
                                    ch[ddx][ddy] = 1;
                                    dist[ddx][ddy] += L;
                                    Q.offer(new Point(ddx, ddy));
                                }
                            }
                        }
                    }
                }
            }
        }
        int min = 10000;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dist[i][j] + " ");
                if(board[i][j] == 4 && dist[i][j] > 0){
                    min = Math.min(min,dist[i][j]);
                }
            }
            System.out.println();
        }
        return min;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        int[][] arr = new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0, 1, 0, 0},
        {0, 2, 1, 1, 3, 0, 4, 0},
        {0, 0, 1, 4, 1, 1, 1, 0}};
        System.out.println(T.solution(arr));
    }
}
