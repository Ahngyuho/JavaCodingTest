package realCode.Prac7;

import java.util.*;

public class Prob2 {
    int solution(int s,int e){
        int[] ch = new int [200001];
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[s] = 1;
        int e_d = 0;
        while(!Q.isEmpty()){
            e_d++;
            e += e_d;
            System.out.println(e);
            int len = Q.size();
            for(int i=0;i<len;i++){
                int p = Q.poll();
                for(int x : new int[]{p+1,p-1,p*2}){
                    if(x == e) {
                        return ++answer;
                    }
                    if(x >= 0 && x<=200000 && ch[x] == 0){
                        Q.offer(x);
                        ch[x] = 1;
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(1,11));
    }
}
