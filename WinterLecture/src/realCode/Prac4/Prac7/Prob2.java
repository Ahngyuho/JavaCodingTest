package realCode.Prac4.Prac7;

import java.util.*;

public class Prob2 {
    int solution(int s,int e){
        int[][] ch = new int [2][200001];
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[0][s] = 1;
        while(!Q.isEmpty()){
            int len = Q.size();
            answer++;
            for(int i=0;i<len;i++){
                int p = Q.poll();
                for(int x : new int[]{p+1,p-1,p*2}){
                    if (x >= 0 && x <= 200000 && ch[answer % 2][x] == 0) {
                        Q.offer(x);
                        ch[answer % 2][x] = 1;
                    }
                }
            }
            e += answer;
            if(e >= 200000) return -1;
            if(ch[answer % 2][e] == 1) {
                return answer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(10,3));
        System.out.println(T.solution(1,34567));
        System.out.println(T.solution(5,6));
    }
}
