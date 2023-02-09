package PracticeCode.Prac7;
import java.util.*;
public class Prob2 {
    //02 03
    public int solution1(int s,int e) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++;
            e = L + e;
            for(int i=0;i<len;i++){
                int t = Q.poll();
                for(int x : new int[]{t-1,t+1,t*2}){
                    if(x < 0 || x > 200000) continue;
                    else {
                        if (x == e) return L;
                        Q.offer(x);
                    }
                }
            }
        }
        return answer;
    }

    public int solution(int s, int e){
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>();
        ch[0][s] = 1;
        ch[1][s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++;
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int nx : new int[]{x-1, x+1, x*2}){
                    if(nx >= 0 && nx <= 200000 && ch[L%2][nx] == 0){
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                        if (L == 19 && nx == 34757) {
                            System.out.print(nx + " ");
                        }
                    }
                }
            }
            e = e + L;
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) {
                System.out.println(e);
                return L;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        //System.out.println(T.solution(1, 11));
       // System.out.println(T.solution(10, 3));
        //System.out.println(T.solution(2, 54321));
        System.out.println(T.solution(6, 6));
    }
}
