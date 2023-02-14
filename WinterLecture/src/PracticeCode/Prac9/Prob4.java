package PracticeCode.Prac9;
import util.MyUtil;

import java.util.*;
public class Prob4 {
    public int solution2(int[][] board) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(cost[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> transCnt = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        transCnt.offer(new int[]{0,0,0});
        while(!transCnt.isEmpty()){
            int[] cur = transCnt.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int k=0;k<4;k++){
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue;
                int dir = board[cur[0]][cur[1]] - 1;
                if(k == dir && cur[2] < cost[nx][ny]){
                    cost[nx][ny] = cur[2];
                    transCnt.offer(new int[]{nx,ny,cost[nx][ny]});
                }else if(k != dir && cur[2] + 1 < cost[nx][ny]){
                    cost[nx][ny] = cur[2] + 1;
                    transCnt.offer(new int[]{nx,ny,cost[nx][ny]});
                }
            }
        }
        return cost[n-1][m-1];
    }
    //01 29
    public int solution1(int[][] board) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(cost[i],Integer.MAX_VALUE);
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cost[cur[0]][cur[1]] < cur[2]) continue;
            for(int k=0;k<4;k++){
                int dir = board[cur[0]][cur[1]] - 1;
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dir == k && cost[nx][ny] > cur[2]){
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx,ny,cost[nx][ny]});
                }else if(cost[nx][ny] > cur[2] + 1){
                    cost[nx][ny] = cur[2] + 1;
                    pq.offer(new int[]{nx,ny,cost[nx][ny]});
                }
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution2(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution2(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution2(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution2(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2 ,2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2,2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution2(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3,2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1,2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
