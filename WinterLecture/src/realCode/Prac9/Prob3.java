package realCode.Prac9;

import java.util.*;

public class Prob3 {
    class Pos implements Comparable<Pos>{
        int x;
        int y;
        int cost;

        Pos(int x,int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o){
            return this.cost - o.cost;
        }
    }
    int solution(int[][] board){
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,0,1};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i],10);
        }
        PriorityQueue<Pos> pQ = new PriorityQueue<>();
        pQ.offer(new Pos(0,0,0));
        cost[0][0] = 0;

        while(!pQ.isEmpty()){
            Pos p = pQ.poll();
            int cc = p.cost;
            if(cost[p.x][p.y] < cc) continue;
            for(int i=0;i<4;i++){
                int ddx = dx[i] + p.x;
                int ddy = dy[i] + p.y;
                if (ddx >= 0 && ddx < n && ddy >= 0 && ddy < m) {
                    if(board[ddx][ddy] == 1 && cc + 1 < cost[ddx][ddy]){
                        cost[ddx][ddy] = p.cost + 1;
                        pQ.offer(new Pos(ddx,ddy,cost[ddx][ddy] + 1));
                    }
                    else if(board[ddx][ddy] == 0 & cc < cost[ddx][ddy]) {
                        cost[ddx][ddy] = p.cost;
                        pQ.offer(new Pos(ddx, ddy, cost[ddx][ddy]));
                    }
                }
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}}));
    }
}
