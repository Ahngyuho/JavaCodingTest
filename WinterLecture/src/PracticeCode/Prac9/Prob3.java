package PracticeCode.Prac9;
import util.MyUtil;

import java.util.*;
public class Prob3 {
    //2023 02 12
    public int solution1(int[][] board) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(cost[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> crashCnt = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        crashCnt.offer(new int[]{0,0,0});
        while(!crashCnt.isEmpty()){
            int[] cur = crashCnt.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int k=0;k<4;k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] == 1 && cur[2] + 1 < cost[nx][ny]){
                    cost[nx][ny] = cur[2] + 1;
                    crashCnt.offer(new int[]{nx,ny,cost[nx][ny]});
                }else if(board[nx][ny] == 0 && cur[2] < cost[nx][ny]){
                    cost[nx][ny] = cur[2];
                    crashCnt.offer(new int[]{nx,ny,cost[nx][ny]});
                }
            }
        }
        return cost[n-1][m-1] == Integer.MAX_VALUE ? -1 : cost[n-1][m-1];
    }
    //01 29
    public int solution(int[][] board) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = board.length;
        int m = board[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2] > dist[cur[0]][cur[1]]) continue;
            for(int k=0;k<4;k++){
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(board[nx][ny] == 0 && dist[nx][ny] > cur[2]){
                        dist[nx][ny] = cur[2];
                        pq.offer(new int[]{nx,ny,dist[nx][ny]});
                    }else if(board[nx][ny] == 1 && dist[nx][ny] > cur[2] + 1){
                        dist[nx][ny] = cur[2] + 1;
                        pq.offer(new int[]{nx,ny,dist[nx][ny]});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution1(new int[][]{{0, 1, 1, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution1(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution1(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution1(new int[][]{{0, 1, 1, 0, 1, 1, 1},{1, 1, 1, 0, 1, 1, 1},{1, 0, 0, 0, 0, 1, 1},{1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution1(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1},{0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1},{1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
