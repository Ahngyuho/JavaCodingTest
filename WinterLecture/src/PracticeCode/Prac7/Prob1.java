package PracticeCode.Prac7;
import java.util.*;
public class Prob1 {
    public int solution2(int[] pool,int a,int b,int home) {
        int[][] visited = new int[2][10001];
        for(int x : pool) {
            visited[0][x] = 1;
            visited[1][x] = 1;
        }
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0});
        visited[0][0] = 1;
        visited[1][0] = 1;
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] cur = Q.poll();
                if(cur[0] == home) return L;
                int x = cur[0] + a;
                if(x <= 10000 && visited[0][x] == 0){
                    visited[0][x] = 1;
                    Q.offer(new int[]{x,0});
                }
                x = cur[0] - b;
                if(x > 0 && visited[1][x] == 0 && cur[1] == 0){
                    visited[1][x] = 1;
                    Q.offer(new int[]{x,1});
                }
            }
            L++;
        }
        return -1;
    }
    public int solution1(int[] pool,int a,int b,int home) {
        int[][] visited = new int[2][10001];
        for(int x : pool) {
            visited[0][x] = 1;
            visited[1][x] = 1;
        }
        Queue<int[]> Q = new LinkedList<>();
        int L = 0;
        Q.offer(new int[]{0,0});
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] p = Q.poll();
                if(p[0] == home) return L;
                if(p[0] + a <= 10000 && visited[0][p[0] + a] == 0){
                    visited[0][p[0] + a] = 1;
                    Q.offer(new int[]{p[0] + a, 0});
                }
                if(p[0] - b > 0 && visited[1][p[0] - b] == 0 && p[1] == 0){
                    visited[1][p[0] - b] = 1;
                    Q.offer(new int[]{p[0] - b,1});
                }
            }
            L++;
        }
        return -1;
    }
    public int solution(int[] pool,int a,int b,int home) {
        int[][] ch = new int[2][10001];
        ch[0][0] = 1;
        ch[1][0] = 1;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0});
        for(int x : pool){
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();

            for(int i=0;i<len;i++){
                int[] cur = Q.poll();
                if(cur[0] == home) return L;
                int nx = cur[0] + a;
                if(nx <= 10001 && ch[0][nx] == 0){
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx,0});
                }
                nx = cur[0] - b;
                if(nx >=0 && ch[1][nx] == 0 && cur[1] == 0){
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx,0});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution2(new int[]{11, 7, 20},3,2,10));
        System.out.println(T.solution2(new int[]{1, 15, 11},3,2,5));
        System.out.println(T.solution2(new int[]{9, 15, 35, 30, 20},2,1,25));
        System.out.println(T.solution2(new int[]{5, 12, 7, 19, 23},3,5,18));
        System.out.println(T.solution2(new int[]{10, 15, 20},3,2,2));
    }
}
