package PracticeCode.Prac1;

import java.util.*;
public class Prob1 {
    char[] solution1(int n, int[][] ladder) {
        char[] alpha = new char[n + 1];
        char[] answer = new char[n + 1];
        for (int i = 0; i < n; i++) alpha[i + 1] = (char) (65 + i);
        int[][] lad = new int[ladder.length][n + 1];
        for (int i = 0; i < ladder.length; i++) {
            for(int x : ladder[i]){
                lad[i][x] = x + 1;
                lad[i][x+1] = x;
            }
        }
        for (int i = 0; i < lad.length; i++) {
            for(int x : lad[i]) System.out.print(x + " ");
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            int idx = i;
            for (int j = 0; j < lad.length; j++) {
                for(int k=1;k<=n;k++){
                    if(lad[j][k] == idx) {
                        idx = k;
                        //System.out.print(alpha[idx] + " ");
                        break;
                    }
                }
            }
            answer[idx] = alpha[i];
        }
        return answer;
    }

    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (i + 65);
        }
        for (int[] line : ladder) {
            for (int x : line) {
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }
            for(char x : answer) System.out.print(x + " ");
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(Arrays.toString(T.solution(5,new int[][]{{1,3},{2,4},{1,4}})));
//        System.out.println(Arrays.toString(T.solution(7,new int[][]{{1,3,5},{1,3,6},{2,4}})));
//        System.out.println(Arrays.toString(T.solution(8,new int[][]{{1,5},{2,4,7},{1,5,7},{2,5,7}})));
//        System.out.println(Arrays.toString(T.solution(12,new int[][]{{1,5,8,10},{2,4,7},{1,5,7,9,11},{2,5,7,10},{3,6,8,11}})));
    }
}
