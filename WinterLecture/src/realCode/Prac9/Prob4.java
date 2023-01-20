package realCode.Prac9;

import java.util.*;

public class Prob4 {
    int solution(int[][] board){
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(cost[i],10);
        cost[0][0] = 0;
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pQ.offer(new int[]{0,0,0});
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(!pQ.isEmpty()){
            int[] cur = pQ.poll();
            if(cost[cur[0]][cur[1]] < cur[2]) continue;
            int dir = board[cur[0]][cur[1]] - 1;
            for(int i=0;i<4;i++){
                int ddx = dx[i] + cur[0];
                int ddy = dy[i] + cur[1];
                if (ddx < 0 || ddx >= n || ddy < 0 || ddy >= m) continue;
                if(i == dir && cost[ddx][ddx] > cur[2]){
                    cost[ddx][ddy] = cur[2];
                    pQ.offer(new int[]{ddx,ddy,cur[2]});
                }else if(i != dir && cost[ddx][ddy] > cur[2] + 1){
                    cost[ddx][ddy] = cur[2] + 1;
                    pQ.offer(new int[]{ddx,ddy,cur[2] + 1});
                }
            }
        }

        return cost[n-1][m-1];
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
    }
}
