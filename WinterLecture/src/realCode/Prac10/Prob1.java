package realCode.Prac10;

import java.util.*;

public class Prob1 {
    int[] pow;
    int[] student;
    int N;
    int answer;
    void DFS(int s,int sum,int T){
        boolean flag = true;
        for(int i=0;i<N;i++){
            if((student[i] & sum) == student[i]) {
                flag = false;
                break;
            }
        }
        if(flag){
            answer++;
        }else{
            for(int i=s;i<=T;i++){
                DFS(i+1,sum + pow[i],T);
            }
        }
    }
    int solution(int T,int[][] hate){
        pow = new int[21];
        pow[1] = 1;
        student = new int[100];
        N = hate.length;
        for(int i=2;i<=T;i++) pow[i] = pow[i-1] * 2;
        for(int i=0;i<N;i++){
            for(int x : hate[i]){
                student[i] += pow[x];
            }
        }
        DFS(1,0,T);
        return answer;
    }
    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(6,new int[][]{{1}, {4, 2}, {3, 2, 6}, {5}, {3, 4, 6}}));
    }
}
