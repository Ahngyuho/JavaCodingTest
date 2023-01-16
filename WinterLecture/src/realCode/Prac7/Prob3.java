package realCode.Prac7;

import java.util.*;

class Point{
    int x,y;
    Point(int x,int y){this.x = x;this.y = y;}
}

public class Prob3 {
    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};
    int solution(int[][] board){
        Queue<Point> Q = new LinkedList<>();
        int[][] dis = new int[7][7];
        Q.add(new Point(0,0));
        board[0][0] = 1;
        while(!Q.isEmpty()){
            Point p = Q.poll();
            for (int i = 0; i < 4; i++) {
                int ddx = dx[i] + p.x;
                int ddy = dy[i] + p.y;
                if(ddx >= 0 && ddx <=6 && ddy >= 0 && ddy <= 6 && board[ddx][ddy] == 0) {
                    board[ddx][ddy] = 1;
                    Q.offer(new Point(ddx, ddy));
                    dis[ddx][ddy] = dis[p.x][p.y] + 1;
                }
            }
        }

        if(board[6][6] == 0) return -1;
        else return dis[6][6];
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
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
