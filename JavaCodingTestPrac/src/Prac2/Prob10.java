package Prac2;
import java.util.*;
public class Prob10 {
    //01 29
    public int[] solution(int n,int[][] votes,int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int[][] report = new int[n][n];
        int[] candidate = new int[n];
        for(int[] x : votes){
            report[x[0]][x[1]] = 1;
        }
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(report[j][i] == 1) cnt++;
            }
            if(cnt >= k) res.add(i);
        }
        for(int x : res){
            for(int i=0;i<n;i++){
                if(report[i][x] == 1) candidate[i]++;
            }
        }
        for(int x : candidate) System.out.print(x + " ");
        return candidate;
    }

    public static void main(String[] args) {
        Prob10 T = new Prob10();
        System.out.println(T.solution(4,new int[][]{{0, 1}, {0, 3}, {1, 2}, {2, 0}, {2, 3}, {3, 0}},2));
    }
}
