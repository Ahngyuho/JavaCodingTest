package realCode.Prac7;

import java.util.*;

public class Prob5 {
    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};
    int solution(int[][] board){
        int answer = 0;
        int n = board.length;
        Queue<Point> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 2) Q.offer(new Point(i,j));
            }
        }
        boolean flag = false;
        while(!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point p = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int ddx = dx[i] + p.x;
                    int ddy = dy[i] + p.y;
                    if(board[ddx][ddy] == 4) flag = true;
                    if(board[ddx][ddy] == 3 && flag){
                        return ++answer;
                    }
                    if(ddx >= 0 && ddx < n && ddy >=0 && ddy < n && board[ddx][ddy] == 1){
                        board[ddx][ddy] = 0;
                        Q.offer(new Point(ddx,ddy));
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        int[][] arr = new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0, 1, 0, 0},
        {0, 2, 1, 1, 3, 0, 4, 0},
        {0, 0, 0, 4, 1, 1, 1, 0}};
        System.out.println(T.solution(arr));
    }
}
