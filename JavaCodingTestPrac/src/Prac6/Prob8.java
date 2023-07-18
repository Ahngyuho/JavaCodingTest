package Prac6;

import java.util.*;

class Point {
    public int x,y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Prob8 {
    int solution(int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dis = new int[7][7];
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0));
        board[0][0] = 1;
//        while (!Q.isEmpty()) {
//            Point tmp = Q.poll();
//            for (int i = 0; i < 4; i++) {
//                int nx = tmp.x + dx[i];
//                int ny = tmp.y + dy[i];
//
//                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {
//                    board[nx][ny] = 1;
//                    Q.offer(new Point(nx, ny));
//                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
//                }
//            }
//        }
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = Q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = tmp.x + dx[k];
                    int y = tmp.y + dy[k];

                    if(x < 0 || x >= 7 || y < 0 || y >= 7 || board[x][y] == 1) continue;

                    board[x][y] = 1;
                    Q.offer(new Point(x, y));
                    dis[x][y] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }

        if(dis[6][6] == 0) return -1;
        return dis[6][6];
    }

    public static void main(String[] args) {
        Prob8 T = new Prob8();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
