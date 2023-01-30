package realCode.Prac7;
import java.util.*;
public class Prob1 {
    public int solution(int[] pool,int a,int b,int home) {
        int answer = 0;
        int[][] ch = new int[2][10001];
        //0 뒤 1 앞
        ch[0][0] = 1;
        ch[1][0] = 1;
        for(int x : pool){
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        Queue<int[]> Q = new LinkedList<>();
        //좌표 ,{앞 or 뒤}
        Q.offer(new int[]{0,0});
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] cur = Q.poll();
                if(cur[0] == home) return L;
                int nx = cur[0] + a;
                if(nx <= 10000 && ch[1][nx] == 0){
                    Q.offer(new int[]{nx,1});
                    ch[1][nx] = 1;
                }
                nx = cur[0] - b;
                if(nx >= 0 && cur[1] != 0 && ch[0][nx] == 0){
                    Q.offer(new int[]{nx,0});
                    ch[0][nx] = 1;
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {

        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
