package realCode.Prac4.Prac7;

import java.util.*;

public class Prob4 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int solution(int[][] board) {
        Queue<Point> Q = new LinkedList<>();
        int n = board.length;
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    int[][] ch = new int[n][n];
                    int L = 0;
                    Q.offer(new Point(i, j));
                    ch[i][j] = 1;
                    while (!Q.isEmpty()) {
                        L++;
                        int len = Q.size();
                        for (int k = 0; k < len; k++) {
                            Point p = Q.poll();
                            for (int z = 0; z < 4; z++) {
                                int ddx = dx[i] + p.x;
                                int ddy = dy[i] + p.y;
                                if (ddx >= 0 && ddx < n && ddy >= 0 && ddy < n && board[ddx][ddy] == 0 && ch[ddx][ddy] == 0) {
                                    ch[ddx][ddy] = 1;
                                    answer[ddx][ddy] += L;
                                    Q.offer(new Point(ddx, ddy));
                                }
                            }
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
                if (board[i][j] == 0) min = Math.min(min, answer[i][j]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        int[][] arr = {{1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
